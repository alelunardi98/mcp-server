package it.alelunardi.ai.mcpserver.repository.insurance;

import it.alelunardi.ai.mcpserver.repository.insurance.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
