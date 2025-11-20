package it.alelunardi.ai.mcpserver.api.tool.insurance;

import it.alelunardi.ai.mcpserver.api.tool.McpToolProvider;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DocumentTools implements McpToolProvider {

    @McpTool(
            name = "document-extract",
            description = "Extracts key information from a PDF document (mock)"
    )
    public Output extractInformationFromDocument(Input input) {
        return new Output(
                "Insurance policy document with basic coverage.",
                List.of("Fire coverage limit 100k", "Exclusion of catastrophic events")
        );
    }

    public record Input(String base64Pdf) {

    }

    public record Output(String summary, List<String> relevantClauses) {

    }
}
