package it.alelunardi.ai.mcpserver.domain.insurance;

import java.math.BigDecimal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PolicyDto {

    private final String id;
    private final String type;
    private final String name;
    private final BigDecimal basePremium;
    private final BigDecimal coverageAmount;
    private final String description;
    private final RequirementsDto requirements;
}
