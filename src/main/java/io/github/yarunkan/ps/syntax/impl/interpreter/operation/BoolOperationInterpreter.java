package io.github.yarunkan.ps.syntax.impl.interpreter.operation;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoolOperationInterpreter extends SpecificOperationInterpreter {

    @Autowired
    public BoolOperationInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionTokenInterpreter,
                                    TokenType expressionType,
                                    VariablesDatabase variablesDatabase) {

        super(variablesDatabase, boolExpressionTokenInterpreter, expressionType);
    }
}