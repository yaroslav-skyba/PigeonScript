package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator operandValidator;
    private final PomidorTokenParser operandTokenParser;

    @Autowired
    public OperandSchema(PomidorTokenValidator operandValidator,
                         PomidorTokenParser operandTokenParser) {

        this.operandValidator = operandValidator;
        this.operandTokenParser = operandTokenParser;
    }

    @Override
    public String getDescription() {
        return "18) <expression-operand> --> <literal> | <var-name>\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return operandValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return operandTokenParser;
    }
}