package it.alelunardi.ai.mcpserver.api.tool.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.CustomerDto;
import it.alelunardi.ai.mcpserver.mapper.insurance.CustomerMapper;
import it.alelunardi.ai.mcpserver.repository.insurance.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerTools {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Tool(name = "customer-lookup", description = "Find customer by id")
    public Output customerLookup(String id) {
        return repository.findById(id)
                .map(c -> new Output(mapper.toCustomerDto(c), "OK"))
                .orElse(new Output(null, "NOT_FOUND"));
    }

    public record Input(String id) {

    }

    public record Output(CustomerDto customer, String status) {

    }
}
