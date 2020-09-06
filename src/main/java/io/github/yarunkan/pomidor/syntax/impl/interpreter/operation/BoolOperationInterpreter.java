package io.github.yarunkan.pomidor.syntax.impl.interpreter.operation;

import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationInterpreter extends SpecificOperationInterpreter<Boolean> {

    @Autowired
    public BoolOperationInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionTokenInterpreter, TokenType expressionType) {

        super(boolExpressionTokenInterpreter, expressionType);
    }
}