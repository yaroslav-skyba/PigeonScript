package io.github.yarunkan.ps.syntax.impl.interpreter.expression;

import io.github.yarunkan.ps.database.variables.VariablesDatabase;
import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StringExpressionInterpreter extends SpecificExpressionInterpreter<String> {

    @Autowired
    protected StringExpressionInterpreter(TokenType operandType, TokenType operatorType, VariablesDatabase variablesDatabase) {

        super(variablesDatabase, operandType, operatorType);
    }

    @Override
    public String[] getExpressionOperands(List<Token> expressionTokens) {

        return getSourceCodeOperands(expressionTokens);
    }

    @Override
    public String calculateExpression(String[] expressionOperators, String[] expressionOperands) {

        if (expressionOperands.length == 1) {

            return expressionOperands[0];
        }

        final String quote = "\"";
        final CharSequence empty = "";

        return quote + String.join(empty, expressionOperands).replace(quote, empty) + quote;
    }
}