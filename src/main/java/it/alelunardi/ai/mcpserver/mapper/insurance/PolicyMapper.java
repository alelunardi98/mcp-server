package it.alelunardi.ai.mcpserver.mapper.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.PolicyDto;
import it.alelunardi.ai.mcpserver.repository.insurance.model.Policy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PolicyMapper {

    Policy toPolicy(PolicyDto policyDto);

    PolicyDto toPolicyDto(Policy policy);
}
