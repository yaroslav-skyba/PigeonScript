package io.github.yarunkan.pomidor.syntax.impl.interpreter.declaration;

import io.github.yarunkan.pomidor.database.variables.VariablesDatabase;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntVarDeclarationInterpreter extends SpecificVarDeclarationInterpreter {

    @Autowired
    public IntVarDeclarationInterpreter(SpecificExpressionInterpreter<Long> intExpressionTokenInterpreter,
                                        VariablesDatabase variablesDatabase) {

        super(variablesDatabase, intExpressionTokenInterpreter);
    }
}