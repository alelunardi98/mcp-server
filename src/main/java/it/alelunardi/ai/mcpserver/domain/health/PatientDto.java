package it.alelunardi.ai.mcpserver.domain.health;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record PatientDto(String firstName, String lastName, LocalDate dateOfBirth) {

}
