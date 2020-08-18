package io.github.mchuhaievskyi.pomidor.syntax.token;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;

public interface PomidorTokenParser {

    PomidorToken parse(String... sourceCodeTokens);
}