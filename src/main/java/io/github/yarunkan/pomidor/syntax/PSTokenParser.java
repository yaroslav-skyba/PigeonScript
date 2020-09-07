package io.github.yarunkan.pomidor.syntax;

import java.util.Optional;

public interface PSTokenParser {

    Optional<Token> peekNextToken();
    Token takeNextToken();
}