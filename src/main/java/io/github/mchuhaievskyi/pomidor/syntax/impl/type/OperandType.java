package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandType implements TokenType {

    @Autowired
    private TokenSchema operandSchema;

    @Override
    public String getName() {
        return "Print command argument token";
    }

    @Override
    public TokenSchema getSchema() {
        return operandSchema;
    }
}