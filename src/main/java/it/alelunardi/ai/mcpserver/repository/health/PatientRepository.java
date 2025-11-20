package it.alelunardi.ai.mcpserver.repository.health;

import it.alelunardi.ai.mcpserver.repository.health.model.Patient;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByLastName(String lastName);

    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Patient> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);
}
