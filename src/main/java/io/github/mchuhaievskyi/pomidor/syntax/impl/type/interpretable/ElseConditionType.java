package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionType implements InterpretableType {

    @Autowired
    private PomidorTokenSchema elseConditionSchema;

    private final PomidorTokenInterpreter elseConditionTokenInterpreter;

    @Autowired
    public ElseConditionType(PomidorTokenInterpreter elseConditionTokenInterpreter) {

        this.elseConditionTokenInterpreter = elseConditionTokenInterpreter;
    }

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return elseConditionTokenInterpreter;
    }

    @Override
    public String getName() {

        return "An else condition token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return elseConditionSchema;
    }
}