package io.github.yarunkan.ps.syntax.token;

public interface TokenSchema {

    String getDescription();
    TokenValidator getTokenValidator();
    TokenParser getTokenParser();
}