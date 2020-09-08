package io.github.yarunkan.ps.syntax.impl.interpreter.declaration;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolVarDeclarationInterpreter extends SpecificVarDeclarationInterpreter {

    @Autowired
    public BoolVarDeclarationInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionTokenInterpreter,
                                         VariablesDatabase variablesDatabase) {

        super(variablesDatabase, boolExpressionTokenInterpreter);
    }
}