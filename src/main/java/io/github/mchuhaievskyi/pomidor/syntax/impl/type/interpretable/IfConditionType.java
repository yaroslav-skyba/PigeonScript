package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionType implements InterpretableType {

    @Autowired
    private PomidorTokenSchema ifConditionSchema;
    @Autowired
    private PomidorTokenInterpreter ifConditionTokenInterpreter;

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return ifConditionTokenInterpreter;
    }

    @Override
    public String getName() {

        return "An if condition token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return ifConditionSchema;
    }
}