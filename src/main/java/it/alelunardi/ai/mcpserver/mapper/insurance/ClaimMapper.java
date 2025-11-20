package it.alelunardi.ai.mcpserver.mapper.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.ClaimDto;
import it.alelunardi.ai.mcpserver.repository.insurance.model.Claim;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    Claim toClaim(ClaimDto claimDto);

    ClaimDto toClaimDto(Claim claim);
}
