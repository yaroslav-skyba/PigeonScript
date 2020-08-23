package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionType implements InterpretableType {

    @Autowired
    private PomidorTokenSchema expressionSchema;

    private final PomidorTokenInterpreter expressionTokenInterpreter;

    @Autowired
    public ExpressionType(PomidorTokenInterpreter expressionTokenInterpreter) {

        this.expressionTokenInterpreter = expressionTokenInterpreter;
    }

    @Override
    public String getName() {

        return "Expression token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return expressionSchema;
    }

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return expressionTokenInterpreter;
    }
}