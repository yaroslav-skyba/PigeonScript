package io.github.yarunkan.ps.syntax.impl.parser.single;

import io.github.yarunkan.ps.syntax.impl.TokenImpl;
import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenType;

public abstract class SingleWordParser implements TokenParser {

    private TokenType type;

    @Override
    public Token parse(String... sourceCodeTokens) {

        return new TokenImpl(getTokenType(), sourceCodeTokens[0]);
    }

    public TokenType getTokenType() {

        return type;
    }

    public void setTokenType(TokenType type) {

        this.type = type;
    }
}