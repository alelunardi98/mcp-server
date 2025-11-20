package it.alelunardi.ai.mcpserver.domain.insurance;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequirementsDto {

    private final int minAge;
    private final int maxAge;
}
