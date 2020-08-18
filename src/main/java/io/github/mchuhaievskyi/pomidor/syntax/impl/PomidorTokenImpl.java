package io.github.mchuhaievskyi.pomidor.syntax.impl;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;

import java.util.Collections;
import java.util.List;

public class PomidorTokenImpl implements PomidorToken {

    private final PomidorTokenType tokenType;
    private final String sourceCode;
    private final List<PomidorToken> subTokens;

    public PomidorTokenImpl(PomidorTokenType tokenType, String sourceCode, List<PomidorToken> subTokens) {

        this.tokenType = tokenType;
        this.sourceCode = sourceCode;
        this.subTokens = subTokens;
    }

    public PomidorTokenImpl(PomidorTokenType tokenType, String sourceCode) {

        this(tokenType, sourceCode, Collections.emptyList());
    }

    @Override
    public PomidorTokenType getType() {
        return tokenType;
    }

    @Override
    public String getSourceCode() {
        return sourceCode;
    }

    @Override
    public List<PomidorToken> getSubTokens() {
        return subTokens;
    }

    @Override
    public String toString() {

        return "PomidorTokenImpl{" +
                "tokenType=" + tokenType +
                ", sourceCode='" + sourceCode + '\'' +
                ", subTokens=" + subTokens +
                '}';
    }
}