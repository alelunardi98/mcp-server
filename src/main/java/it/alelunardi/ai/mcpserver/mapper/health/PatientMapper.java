package it.alelunardi.ai.mcpserver.mapper.health;

import it.alelunardi.ai.mcpserver.domain.health.PatientDto;
import it.alelunardi.ai.mcpserver.repository.health.model.Patient;
import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "registrationDate", expression = "java(getCurrentDate())")
    Patient toPatient(PatientDto patientDto);

    @Named("getCurrentDate")
    default LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
