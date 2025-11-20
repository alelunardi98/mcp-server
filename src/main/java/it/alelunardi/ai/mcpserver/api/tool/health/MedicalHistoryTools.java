package it.alelunardi.ai.mcpserver.api.tool.health;

import it.alelunardi.ai.mcpserver.api.tool.McpToolProvider;
import it.alelunardi.ai.mcpserver.domain.health.MedicalHistoryDto;
import it.alelunardi.ai.mcpserver.mapper.health.MedicalHistoryMapper;
import it.alelunardi.ai.mcpserver.repository.health.MedicalHistoryRepository;
import it.alelunardi.ai.mcpserver.repository.health.PatientRepository;
import it.alelunardi.ai.mcpserver.repository.health.model.MedicalHistory;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicalHistoryTools implements McpToolProvider {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final PatientRepository patientRepository;
    private final MedicalHistoryMapper medicalHistoryMapper;

    @McpTool(name = "Get_Patient_full_Medical_History_by_Patient_ID",
            description = "Get Patient full Medical History by real Patient ID")
    public List<MedicalHistory> findByPatientId(Long patientId) {
        log.info("Getting Medical History by Patient Id: {}", patientId);
        return medicalHistoryRepository.findByPatientId(patientId);
    }

    @McpTool(name = "Get_Patient_Medical_History_by_Patient_ID_and_Date_Range",
            description = "Get Patient Medical History Patient ID and Date Range")
    public List<MedicalHistory> findByPatientIdAndVisitDateBetween(Long patientId,
            LocalDate startDate,
            LocalDate endDate) {
        log.info("Getting Medical History by Patient ID: {} between {} and {}", patientId, startDate, endDate);
        return medicalHistoryRepository.findByPatientIdAndVisitDateBetween(patientId, startDate, endDate);
    }

    @McpTool(name = "Adding_Patient_new_Medical_History_by_Patient_ID",
            description = "Adding Patient new Medical History record by real Patient ID")
    public MedicalHistory add(MedicalHistoryDto medicalHistoryDto) {
        var medicalHistoryExistingOptional =
                medicalHistoryRepository.findByPatientIdAndVisitDate(medicalHistoryDto.patientId(),
                        medicalHistoryDto.visitDate());

        if (medicalHistoryExistingOptional.isPresent()) {
            throw new IllegalStateException("Medical History already exists for the same Patient and Date");
        }

        var patient = patientRepository.findById(medicalHistoryDto.patientId())
                .orElseThrow(() -> new IllegalStateException("Patient not found"));

        var medicalHistory = medicalHistoryMapper.toMedicalHistory(medicalHistoryDto);
        medicalHistory.setPatient(patient);

        log.info("Adding new Medical History {}", medicalHistoryDto);
        return medicalHistoryRepository.save(medicalHistory);
    }

    @McpTool(name = "Changing_existing_Patient_Medical_History",
            description = "Changing existing Patient Medical History record by real Patient ID and Visit Date")
    public MedicalHistory update(MedicalHistoryDto medicalHistoryDto) {
        log.info("Updating Medical History {}", medicalHistoryDto);
        return medicalHistoryRepository.findByPatientIdAndVisitDate(medicalHistoryDto.patientId(),
                        medicalHistoryDto.visitDate())
                .map(existingHistory -> {
                    mergeMedicalHistory(medicalHistoryDto, existingHistory);
                    return medicalHistoryRepository.save(existingHistory);
                })
                .orElseThrow(() ->
                        new IllegalStateException("Medical History not found for the given Patient and Visit Date"));
    }

    private void mergeMedicalHistory(MedicalHistoryDto medicalHistoryDto, MedicalHistory existingHistory) {
        existingHistory.setDiagnosis(medicalHistoryDto.diagnosis());
        existingHistory.setTreatment(medicalHistoryDto.treatment());
        existingHistory.setNotes(medicalHistoryDto.notes());
        existingHistory.setPrescribedMedications(medicalHistoryDto.prescribedMedications());
        existingHistory.setDoctorName(medicalHistoryDto.doctorName());
        existingHistory.setVisitType(medicalHistoryDto.visitType());
    }
}
