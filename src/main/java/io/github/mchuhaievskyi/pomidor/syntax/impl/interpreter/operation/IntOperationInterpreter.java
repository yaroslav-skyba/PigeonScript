package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntOperationInterpreter extends SpecificOperationInterpreter<Long> {

    @Autowired
    public IntOperationInterpreter(SpecificExpressionInterpreter<Long> intExpressionTokenInterpreter, TokenType expressionType) {

        super(intExpressionTokenInterpreter, expressionType);
    }
}