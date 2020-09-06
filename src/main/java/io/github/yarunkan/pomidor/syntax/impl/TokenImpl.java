package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.TokenType;

import java.util.Collections;
import java.util.List;

public class TokenImpl implements Token {

    private final TokenType type;
    private final String sourceCode;
    private final List<Token> subTokens;

    public TokenImpl(TokenType type, String sourceCode, List<Token> subTokens) {

        this.type = type;
        this.sourceCode = sourceCode;
        this.subTokens = subTokens;
    }

    public TokenImpl(TokenType type, String sourceCode) {

        this(type, sourceCode, Collections.emptyList());
    }

    @Override
    public TokenType getType() {
        return type;
    }

    @Override
    public String getSourceCode() {
        return sourceCode;
    }

    @Override
    public List<Token> getSubTokens() {
        return subTokens;
    }

    @Override
    public String toString() {

        return "PomidorTokenImpl{" +
                "tokenType=" + type +
                ", sourceCode='" + sourceCode + '\'' +
                ", subTokens=" + subTokens +
                '}';
    }
}