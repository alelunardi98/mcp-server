package it.alelunardi.ai.mcpserver.domain.insurance;

import java.math.BigDecimal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerDto {

    private final String id;
    private final String fullName;
    private final Integer age;
    private final String profession;
    private final BigDecimal grossAnnualIncome;
    private final String address;
    private final boolean smoker;
}
