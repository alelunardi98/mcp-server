package it.alelunardi.ai.mcpserver.repository.health;

import it.alelunardi.ai.mcpserver.repository.health.model.MedicalHistory;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

    List<MedicalHistory> findByPatientId(Long patientId);

    List<MedicalHistory> findByPatientIdAndVisitDateBetween(Long patientId, LocalDate startDate, LocalDate endDate);

    Optional<MedicalHistory> findByPatientIdAndVisitDate(Long patientId, LocalDate visitDate);
}
