package io.github.yarunkan.ps.syntax.impl.type;

import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LiteralType implements TokenType {

    private final TokenSchema literalSchema;

    @Lazy
    @Autowired
    public LiteralType(TokenSchema literalSchema) {

        this.literalSchema = literalSchema;
    }

    @Override
    public String getName() {
        return "A literal token";
    }

    @Override
    public TokenSchema getSchema() {
        return literalSchema;
    }
}