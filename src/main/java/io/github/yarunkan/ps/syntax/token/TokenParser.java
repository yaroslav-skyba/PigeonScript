package io.github.yarunkan.ps.syntax.token;

import io.github.yarunkan.ps.syntax.Token;

public interface TokenParser {

    Token parse(String... sourceCodeTokens);
}