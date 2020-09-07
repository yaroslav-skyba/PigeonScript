package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class IfConditionType implements InterpretableType {

    private final TokenSchema ifConditionSchema;
    private final AbstractTokenInterpreter ifConditionInterpreter;

    @Lazy
    @Autowired
    public IfConditionType(TokenSchema ifConditionSchema, AbstractTokenInterpreter ifConditionInterpreter) {

        this.ifConditionSchema = ifConditionSchema;
        this.ifConditionInterpreter = ifConditionInterpreter;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return ifConditionInterpreter;
    }

    @Override
    public String getName() {

        return "An if condition token";
    }

    @Override
    public TokenSchema getSchema() {

        return ifConditionSchema;
    }
}