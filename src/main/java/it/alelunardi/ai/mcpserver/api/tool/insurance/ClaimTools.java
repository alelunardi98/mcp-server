package it.alelunardi.ai.mcpserver.api.tool.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.ClaimDto;
import it.alelunardi.ai.mcpserver.mapper.insurance.ClaimMapper;
import it.alelunardi.ai.mcpserver.repository.insurance.ClaimRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimTools {

    private final ClaimRepository repository;
    private final ClaimMapper mapper;

    @Tool(
            name = "claim_analyze",
            description = "Analyze a claim and return util information about it"
    )
    public Output analyzeClaim(Input input) {
        ClaimDto claim = repository.findById(input.claimId())
                .map(mapper::toClaimDto)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found"));

        String desc = claim.getDescription().toLowerCase();

        String type;
        String range;

        if (desc.contains("tamponamento")) {
            type = "INCIDENTE STRADALE";
            range = "2000-5000";
        } else if (desc.contains("incendio")) {
            type = "INCENDIO";
            range = "5000-25000";
        } else {
            type = "GENERICO";
            range = "1000-10000";
        }

        List<String> risks = List.of(
                "Verificare responsabilità",
                "Controllare documentazione fotografica",
                "Validare preventivi di riparazione"
        );

        return new Output(type, risks, range);
    }

    public record Input(String claimId) {

    }

    public record Output(String type, List<String> risks, String liquidationRange) {

    }
}
