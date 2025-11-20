package it.alelunardi.ai.mcpserver.repository.insurance;

import it.alelunardi.ai.mcpserver.repository.insurance.model.Policy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, String> {

    @Query("SELECT p FROM Policy p WHERE p.type = :type AND p.minAge <= :age AND p.maxAge >= :age")
    List<Policy> findByTypeAndAge(@Param("type") String type, @Param("age") int age);
}
