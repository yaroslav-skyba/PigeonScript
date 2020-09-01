package io.github.mchuhaievskyi.pomidor.syntax;

import java.util.Optional;

public interface TokenParser {

    Optional<Token> peekNextToken();
    Token takeNextToken();
}