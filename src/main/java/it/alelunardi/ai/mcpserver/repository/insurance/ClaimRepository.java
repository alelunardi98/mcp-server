package it.alelunardi.ai.mcpserver.repository.insurance;


import it.alelunardi.ai.mcpserver.repository.insurance.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, String> {

}
