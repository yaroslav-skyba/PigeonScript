package io.github.mchuhaievskyi.pomidor.syntax;

import java.util.Optional;

public interface PomidorParser {

    Optional<PomidorToken> peekNextToken();
    PomidorToken takeNextToken();
}