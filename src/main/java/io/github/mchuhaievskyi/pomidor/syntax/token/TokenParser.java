package io.github.mchuhaievskyi.pomidor.syntax.token;

import io.github.mchuhaievskyi.pomidor.syntax.Token;

public interface TokenParser {

    Token parse(String... sourceCodeTokens);
}