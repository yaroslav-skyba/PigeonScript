package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator expressionValidator;
    private final PomidorTokenParser expressionTokenParser;

    @Autowired
    public ExpressionSchema(PomidorTokenValidator expressionValidator,
                            PomidorTokenParser expressionTokenParser) {

        this.expressionValidator = expressionValidator;
        this.expressionTokenParser = expressionTokenParser;
    }

    @Override
    public String getDescription() {

        return "17) <expression> --> <expression-operand> <empty> | (<expression-operator> <expression>)";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {

        return expressionValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {

        return expressionTokenParser;
    }
}