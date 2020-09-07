package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ExpressionType implements InterpretableType {

    private final TokenSchema expressionSchema;
    private final AbstractTokenInterpreter expressionInterpreter;

    @Autowired
    public ExpressionType(@Lazy TokenSchema expressionSchema, AbstractTokenInterpreter expressionInterpreter) {

        this.expressionInterpreter = expressionInterpreter;
        this.expressionSchema = expressionSchema;
    }

    @Override
    public String getName() {

        return "An expression token";
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