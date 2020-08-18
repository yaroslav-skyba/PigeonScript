package io.github.mchuhaievskyi.pomidor.syntax;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;

import java.util.List;

public interface PomidorToken {

    PomidorTokenType getType();
    String getSourceCode();
    List<PomidorToken> getSubTokens();
}