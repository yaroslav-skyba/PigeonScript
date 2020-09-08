package io.github.yarunkan.ps.syntax;

import io.github.yarunkan.ps.syntax.token.TokenType;
import java.util.List;

public interface Token {

    TokenType getType();
    String getSourceCode();
    List<Token> getSubTokens();
}