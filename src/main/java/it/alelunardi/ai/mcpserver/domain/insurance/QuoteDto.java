package it.alelunardi.ai.mcpserver.domain.insurance;

import java.math.BigDecimal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuoteDto {

    private final String id;
    private final String customerId;
    private final String policyId;
    private final BigDecimal annualPremium;
    private final String justification;
}
