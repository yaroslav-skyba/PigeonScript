package io.github.mchuhaievskyi.pomidor.syntax.token;

public interface PomidorTokenSchema {

    String getDescription();
    PomidorTokenValidator getTokenValidator();
    PomidorTokenParser getTokenParser();
}