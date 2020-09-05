package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionType implements InterpretableType {

    @Autowired
    private TokenSchema elseConditionSchema;

    private final AbstractTokenInterpreter elseConditionInterpreter;

    @Autowired
    public ElseConditionType(AbstractTokenInterpreter elseConditionInterpreter) {

        this.elseConditionInterpreter = elseConditionInterpreter;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return elseConditionInterpreter;
    }

    @Override
    public String getName() {

        return "An else condition token";
    }

    @Override
    public TokenSchema getSchema() {

        return elseConditionSchema;
    }
}