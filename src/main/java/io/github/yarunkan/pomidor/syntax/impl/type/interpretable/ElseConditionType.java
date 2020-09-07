package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionType implements InterpretableType {

    private final TokenSchema elseConditionSchema;
    private final AbstractTokenInterpreter elseConditionInterpreter;

    @Autowired
    public ElseConditionType(AbstractTokenInterpreter elseConditionInterpreter, @Lazy TokenSchema elseConditionSchema) {

        this.elseConditionInterpreter = elseConditionInterpreter;
        this.elseConditionSchema = elseConditionSchema;
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