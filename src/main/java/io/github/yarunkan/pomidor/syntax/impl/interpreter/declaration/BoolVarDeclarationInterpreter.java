package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolVarDeclarationInterpreter<T> extends SpecificVarDeclarationInterpreter<Boolean> {

    @Autowired
    public BoolVarDeclarationInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionTokenInterpreter) {

        super(boolExpressionTokenInterpreter);
    }
}