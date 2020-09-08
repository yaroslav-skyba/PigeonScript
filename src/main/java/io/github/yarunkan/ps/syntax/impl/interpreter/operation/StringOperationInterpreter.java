package io.github.yarunkan.ps.syntax.impl.interpreter.operation;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringOperationInterpreter extends SpecificOperationInterpreter {

    @Autowired
    public StringOperationInterpreter(SpecificExpressionInterpreter<String> stringExpressionTokenInterpreter,
                                      TokenType expressionType,
                                      VariablesDatabase variablesDatabase) {

        super(variablesDatabase, stringExpressionTokenInterpreter, expressionType);
    }
}