package it.alelunardi.ai.mcpserver.api.tool.demo;

import it.alelunardi.ai.mcpserver.api.tool.McpToolProvider;
import java.util.List;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class AuthorTools implements McpToolProvider {

    @McpTool(name = "author-by-article-title", description = "Get Baeldung author details using an article title")
    Author getAuthorByArticleTitle(@McpToolParam(description = "Article title") String articleTitle) {
        return new Author("John Doe", "john.doe@baeldung.com");
    }

    @McpTool(name = "top-authors", description = "Get highest rated Baeldung authors")
    List<Author> getTopAuthors() {
        return List.of(
                new Author("John Doe", "john.doe@baeldung.com"),
                new Author("Jane Doe", "jane.doe@baeldung.com")
        );
    }

    record Author(String name, String email) {

    }
}
