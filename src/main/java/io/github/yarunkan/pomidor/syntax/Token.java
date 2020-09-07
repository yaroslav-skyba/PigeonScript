package io.github.yarunkan.pomidor.syntax;

import io.github.yarunkan.pomidor.syntax.token.TokenType;
import java.util.List;

public interface Token {

    TokenType getType();
    String getSourceCode();
    List<Token> getSubTokens();
}