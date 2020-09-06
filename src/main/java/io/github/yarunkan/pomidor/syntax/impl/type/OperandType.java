package io.github.yarunkan.pomidor.syntax.impl.type;

import io.github.yarunkan.pomidor.syntax.token.*;
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