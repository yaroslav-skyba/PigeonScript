package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameType implements TokenType {

    @Autowired
    private TokenSchema varNameSchema;

    @Override
    public String getName() {
        return "Variable name token";
    }

    @Override
    public TokenSchema getSchema() {
        return varNameSchema;
    }
}