package io.github.mchuhaievskyi.pomidor.syntax.token;

public interface TokenSchema {

    String getDescription();
    TokenValidator getTokenValidator();
    TokenParser getTokenParser();
}