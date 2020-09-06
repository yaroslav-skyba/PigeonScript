package io.github.yarunkan.pomidor.syntax.token;

public interface TokenSchema {

    String getDescription();
    TokenValidator getTokenValidator();
    TokenParser getTokenParser();
}