package it.alelunardi.ai.mcpserver.mapper.health;

import it.alelunardi.ai.mcpserver.domain.health.MedicalHistoryDto;
import it.alelunardi.ai.mcpserver.repository.health.model.MedicalHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {

    MedicalHistory toMedicalHistory(MedicalHistoryDto medicalHistoryDto);
}
