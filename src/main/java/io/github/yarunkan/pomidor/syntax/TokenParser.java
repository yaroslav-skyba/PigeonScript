package io.github.yarunkan.pomidor.syntax;

import java.util.Optional;

public interface TokenParser {

    Optional<Token> peekNextToken();
    Token takeNextToken();
}