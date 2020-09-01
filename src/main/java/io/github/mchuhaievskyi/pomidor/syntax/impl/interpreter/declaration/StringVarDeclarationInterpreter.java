package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringVarDeclarationInterpreter<T> extends SpecificVarDeclarationInterpreter<String> {

    @Autowired
    public StringVarDeclarationInterpreter(SpecificExpressionInterpreter<String> stringExpressionTokenInterpreter) {

        super(stringExpressionTokenInterpreter);
    }
}