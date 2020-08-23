package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringVarDeclarationTokenInterpreter<T> extends SpecificVarDeclarationTokenInterpreter<String> {

    @Autowired
    public StringVarDeclarationTokenInterpreter(SpecificExpressionTokenInterpreter<String> stringExpressionTokenInterpreter) {

        super(stringExpressionTokenInterpreter);
    }
}