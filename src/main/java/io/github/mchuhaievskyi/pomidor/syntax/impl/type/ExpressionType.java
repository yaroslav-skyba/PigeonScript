package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionType implements PomidorTokenType {

    @Autowired
    private PomidorTokenSchema expressionSchema;

    @Override
    public String getName() {

        return "Expression token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return expressionSchema;
    }
}