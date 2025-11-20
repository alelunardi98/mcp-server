package it.alelunardi.ai.mcpserver.configuration;

import it.alelunardi.ai.mcpserver.api.tool.demo.AuthorTools;
import it.alelunardi.ai.mcpserver.api.tool.health.MedicalHistoryTools;
import it.alelunardi.ai.mcpserver.api.tool.health.PatientTools;
import it.alelunardi.ai.mcpserver.api.tool.insurance.ClaimTools;
import it.alelunardi.ai.mcpserver.api.tool.insurance.CustomerTools;
import it.alelunardi.ai.mcpserver.api.tool.insurance.DocumentTools;
import it.alelunardi.ai.mcpserver.api.tool.insurance.PolicyTools;
import it.alelunardi.ai.mcpserver.api.tool.insurance.QuoteTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    ToolCallbackProvider toolCallbackProvider(
            MedicalHistoryTools medicalHistoryTools,
            AuthorTools authorTools,
            PatientTools patientTools,
            ClaimTools claimTools,
            DocumentTools documentTools,
            CustomerTools customerTools,
            PolicyTools policyTools,
            QuoteTools quoteTools) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(
                        authorTools,
                        patientTools,
                        medicalHistoryTools,
                        claimTools,
                        documentTools,
                        customerTools,
                        policyTools,
                        quoteTools)
                .build();
    }
}
