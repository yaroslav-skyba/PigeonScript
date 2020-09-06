package io.github.yarunkan.pomidor.syntax.impl.type;

import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiteralType implements TokenType {

    @Autowired
    private TokenSchema literalSchema;

    @Override
    public String getName() {
        return "Literal token";
    }

    @Override
    public TokenSchema getSchema() {
        return literalSchema;
    }
}