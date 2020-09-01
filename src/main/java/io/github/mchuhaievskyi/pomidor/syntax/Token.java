package io.github.mchuhaievskyi.pomidor.syntax;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;

import java.util.List;

public interface Token {

    TokenType getType();
    String getSourceCode();
    List<Token> getSubTokens();
}