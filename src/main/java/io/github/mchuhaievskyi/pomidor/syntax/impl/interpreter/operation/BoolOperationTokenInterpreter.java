package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationTokenInterpreter extends SpecificOperationTokenInterpreter<Boolean> {

    @Autowired
    public BoolOperationTokenInterpreter(SpecificExpressionTokenInterpreter<Boolean> boolExpressionTokenInterpreter) {

        super(boolExpressionTokenInterpreter);
    }
}