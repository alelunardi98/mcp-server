package it.alelunardi.ai.mcpserver.api.tool.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.CustomerDto;
import it.alelunardi.ai.mcpserver.mapper.insurance.CustomerMapper;
import it.alelunardi.ai.mcpserver.mapper.insurance.PolicyMapper;
import it.alelunardi.ai.mcpserver.repository.insurance.CustomerRepository;
import it.alelunardi.ai.mcpserver.repository.insurance.PolicyRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuoteTools {

    private final CustomerRepository customerRepository;
    private final PolicyRepository policyRepository;
    private final CustomerMapper customerMapper;
    private final PolicyMapper policyMapper;

    @Tool(
            name = "quote_generate",
            description = "Generate a quote based on a customer and a policy"
    )
    public Output generateQuote(String customerId, String policyId) {

        var customer = customerMapper.toCustomerDto(customerRepository.findById(customerId)
                .orElseThrow());
        var policy = policyMapper.toPolicyDto(policyRepository.findById(policyId)
                .orElseThrow());

        BigDecimal premium = policy.getBasePremium();

        if (olderThan(customer, 40)) {
            premium = premium.multiply(BigDecimal.valueOf(1.2));
        }
        if (customer.isSmoker()) {
            premium = premium.multiply(BigDecimal.valueOf(1.3));
        }

        return new Output(
                premium,
                "Premium based on age %d e smoker=%s".formatted(
                        customer.getAge(), customer.isSmoker() ? "YES" : "NO"
                )
        );
    }

    private boolean olderThan(CustomerDto cliente, int ageLimit) {
        return cliente.getAge() > ageLimit;
    }

    public record Input(String customerId, String policyId) {

    }

    public record Output(BigDecimal premioAnnuale, String motivazione) {

    }
}
