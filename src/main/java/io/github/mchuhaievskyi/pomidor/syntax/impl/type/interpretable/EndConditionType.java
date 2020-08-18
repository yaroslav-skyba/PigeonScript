package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionType implements InterpretableType {

    @Autowired
    private PomidorTokenSchema endConditionSchema;
    @Autowired
    private PomidorTokenInterpreter endConditionTokenInterpreter;

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return endConditionTokenInterpreter;
    }

    @Override
    public String getName() {

        return "An end condition token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return endConditionSchema;
    }
}