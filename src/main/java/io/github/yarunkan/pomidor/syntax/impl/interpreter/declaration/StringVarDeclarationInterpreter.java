package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringVarDeclarationInterpreter extends SpecificVarDeclarationInterpreter {

    @Autowired
    public StringVarDeclarationInterpreter(SpecificExpressionInterpreter<String> stringExpressionTokenInterpreter,
                                           VariablesDatabase variablesDatabase) {

        super(variablesDatabase, stringExpressionTokenInterpreter);
    }
}