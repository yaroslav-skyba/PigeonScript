package io.github.yarunkan.pomidor.syntax.token;

import io.github.yarunkan.pomidor.syntax.Token;

public interface TokenParser {

    Token parse(String... sourceCodeTokens);
}