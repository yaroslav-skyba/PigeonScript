package io.github.yarunkan.pomidor.syntax.impl.type;

import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VarNameType implements TokenType {

    private final TokenSchema varNameSchema;

    @Autowired
    @Lazy
    public VarNameType(TokenSchema varNameSchema) {

        this.varNameSchema = varNameSchema;
    }

    @Override
    public String getName() {
        return "A variable name token";
    }

    @Override
    public TokenSchema getSchema() {
        return varNameSchema;
    }
}