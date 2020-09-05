package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionType implements InterpretableType {

    @Autowired
    private TokenSchema ifConditionSchema;
    @Autowired
    private AbstractTokenInterpreter ifConditionInterpreter;

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