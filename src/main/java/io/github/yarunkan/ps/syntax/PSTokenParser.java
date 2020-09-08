package io.github.yarunkan.ps.syntax;

import java.util.Optional;

public interface PSTokenParser {

    Optional<Token> peekNextToken();
    Token takeNextToken();
}