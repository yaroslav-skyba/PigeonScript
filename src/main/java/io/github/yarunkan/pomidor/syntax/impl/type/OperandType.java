package io.github.yarunkan.pomidor.syntax.impl.type;

import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OperandType implements TokenType {

    private final TokenSchema operandSchema;

    @Lazy
    @Autowired
    public OperandType(TokenSchema operandSchema) {

        this.operandSchema = operandSchema;
    }

    @Override
    public String getName() {
        return "A operand token";
    }

    @Override
    public TokenSchema getSchema() {
        return operandSchema;
    }
}