package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolVarDeclarationTokenInterpreter<T> extends SpecificVarDeclarationTokenInterpreter<Boolean> {

    @Autowired
    public BoolVarDeclarationTokenInterpreter(SpecificExpressionTokenInterpreter<Boolean> boolExpressionTokenInterpreter) {

        super(boolExpressionTokenInterpreter);
    }
}