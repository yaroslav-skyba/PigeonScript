package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntVarDeclarationInterpreter<T> extends SpecificVarDeclarationInterpreter<Long> {

    @Autowired
    public IntVarDeclarationInterpreter(SpecificExpressionInterpreter<Long> intExpressionTokenInterpreter) {

        super(intExpressionTokenInterpreter);
    }
}