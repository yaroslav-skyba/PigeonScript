package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordType implements TokenType {

    @Autowired
    private TokenSchema keywordSchema;

    @Override
    public String getName() {
        return "Keyword token";
    }

    @Override
    public TokenSchema getSchema() {
        return keywordSchema;
    }
}