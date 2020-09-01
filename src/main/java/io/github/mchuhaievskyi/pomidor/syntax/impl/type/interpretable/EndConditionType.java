package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionType implements InterpretableType {

    @Autowired
    private TokenSchema endConditionSchema;
    @Autowired
    private TokenInterpreter endConditionInterpreter;

    @Override
    public TokenInterpreter getInterpreter() {

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