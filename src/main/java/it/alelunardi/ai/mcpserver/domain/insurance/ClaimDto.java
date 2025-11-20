package it.alelunardi.ai.mcpserver.domain.insurance;

import java.math.BigDecimal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClaimDto {

    private String id;
    private String policyId;
    private BigDecimal estimatedDamageValue;
    private String description;
    private String status;
}
