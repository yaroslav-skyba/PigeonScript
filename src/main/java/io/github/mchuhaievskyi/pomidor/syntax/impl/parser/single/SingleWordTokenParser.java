package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single;

import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;

public abstract class SingleWordTokenParser implements PomidorTokenParser {

    private PomidorTokenType tokenType;

    @Override
    public PomidorToken parse(String... tokens) {

        return new PomidorTokenImpl(getTokenType(), tokens[0]);
    }

    public PomidorTokenType getTokenType() {

        return tokenType;
    }

    public void setTokenType(PomidorTokenType tokenType) {

        this.tokenType = tokenType;
    }
}