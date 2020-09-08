package io.github.yarunkan.ps.syntax.impl.type;

import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class KeywordType implements TokenType {

    private final TokenSchema keywordSchema;

    @Lazy
    @Autowired
    public KeywordType(TokenSchema keywordSchema) {

        this.keywordSchema = keywordSchema;
    }

    @Override
    public String getName() {
        return "A keyword token";
    }

    @Override
    public TokenSchema getSchema() {
        return keywordSchema;
    }
}