package it.alelunardi.ai.mcpserver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.http.McpHttpHandler;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.spec.McpSchema.Implementation;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
import it.alelunardi.ai.mcpserver.api.tool.McpToolProvider;
import java.util.List;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ToolCallbackProvider toolCallbackProvider(List<McpToolProvider> allTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(allTools.toArray())
                .build();
    }

    @Bean
    public McpServer mcpServer(ToolCallbackProvider toolProvider) {
        return McpServer.sync()
                .serverInfo(new Implementation("My Server", "1.0"))
                .capabilities(ServerCapabilities.builder().tools(true).build())
                .tools(toolProvider.getToolCallbacks())
                .build();
    }

    @Bean
    public McpHttpHandler mcpHttpHandler(McpServer mcpServer, ObjectMapper objectMapper) {
        return new McpHttpHandler(mcpServer, objectMapper);
    }

    @Bean
    public RouterFunction<ServerResponse> mcpRouter(McpServer mcpServer) {
        return RouterFunctions.route()
                .POST("/mcp", new McpHttpHandler(mcpServer))
                .build();
    }
}
