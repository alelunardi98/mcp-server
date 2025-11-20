package it.alelunardi.ai.mcpserver.domain.health;

import it.alelunardi.ai.mcpserver.repository.health.model.VisitType;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record MedicalHistoryDto(Long patientId,
                                LocalDate visitDate,
                                String diagnosis,
                                String treatment,
                                String notes,
                                String prescribedMedications,
                                String doctorName,
                                VisitType visitType) {

}
