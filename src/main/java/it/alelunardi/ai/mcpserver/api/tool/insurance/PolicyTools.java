package it.alelunardi.ai.mcpserver.api.tool.insurance;

import it.alelunardi.ai.mcpserver.api.tool.McpToolProvider;
import it.alelunardi.ai.mcpserver.domain.insurance.PolicyDto;
import it.alelunardi.ai.mcpserver.mapper.insurance.PolicyMapper;
import it.alelunardi.ai.mcpserver.repository.insurance.PolicyRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PolicyTools implements McpToolProvider {

    private final PolicyRepository repository;
    private final PolicyMapper mapper;

    @McpTool(
            name = "policy-search",
            description = "Find appropriate insurance policies based on a type and age"
    )
    public Output searchPolicy(String type, Integer age) {
        List<PolicyDto> policies = repository.findByTypeAndAge(type, age)
                .stream()
                .map(mapper::toPolicyDto)
                .collect(Collectors.toList());
        return new Output(policies);
    }

    public record Input(String type, Integer age) {

    }

    public record Output(List<PolicyDto> policies) {

    }
}
