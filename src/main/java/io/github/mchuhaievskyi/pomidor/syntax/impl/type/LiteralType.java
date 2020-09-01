package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
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