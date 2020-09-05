package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpressionType implements InterpretableType {

    @Autowired
    private TokenSchema expressionSchema;

    private final AbstractTokenInterpreter expressionInterpreter;

    @Autowired
    public ExpressionType(AbstractTokenInterpreter expressionInterpreter) {

        this.expressionInterpreter = expressionInterpreter;
    }

    @Override
    public String getName() {

        return "Expression token";
    }

    @Override
    public TokenSchema getSchema() {

        return expressionSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return expressionInterpreter;
    }
}