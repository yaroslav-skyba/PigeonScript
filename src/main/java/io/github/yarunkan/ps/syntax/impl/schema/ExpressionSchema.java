package io.github.yarunkan.ps.syntax.impl.schema;

import io.github.yarunkan.ps.syntax.token.TokenParser;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionSchema implements TokenSchema {

    private final TokenValidator expressionValidator;
    private final TokenParser expressionParser;

    @Autowired
    public ExpressionSchema(TokenValidator expressionValidator,
                            TokenParser expressionParser) {

        this.expressionValidator = expressionValidator;
        this.expressionParser = expressionParser;
    }

    @Override
    public String getDescription() {

        return "17) <expression> --> <expression-operand> <empty> | (<expression-operator> <expression>)";
    }

    @Override
    public TokenValidator getTokenValidator() {

        return expressionValidator;
    }

    @Override
    public TokenParser getTokenParser() {

        return expressionParser;
    }
}