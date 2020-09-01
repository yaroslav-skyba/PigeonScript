package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionType implements InterpretableType {

    @Autowired
    private TokenSchema elseConditionSchema;

    private final TokenInterpreter elseConditionInterpreter;

    @Autowired
    public ElseConditionType(TokenInterpreter elseConditionInterpreter) {

        this.elseConditionInterpreter = elseConditionInterpreter;
    }

    @Override
    public TokenInterpreter getInterpreter() {

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