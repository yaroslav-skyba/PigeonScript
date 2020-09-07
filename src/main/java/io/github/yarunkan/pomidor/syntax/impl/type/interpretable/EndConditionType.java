package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class EndConditionType implements InterpretableType {

    private final TokenSchema endConditionSchema;
    private final AbstractTokenInterpreter endConditionInterpreter;

    @Autowired
    @Lazy
    public EndConditionType(TokenSchema endConditionSchema, AbstractTokenInterpreter endConditionInterpreter) {

        this.endConditionSchema = endConditionSchema;
        this.endConditionInterpreter = endConditionInterpreter;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return endConditionInterpreter;
    }

    @Override
    public String getName() {

        return "An end condition token";
    }

    @Override
    public TokenSchema getSchema() {

        return endConditionSchema;
    }
}