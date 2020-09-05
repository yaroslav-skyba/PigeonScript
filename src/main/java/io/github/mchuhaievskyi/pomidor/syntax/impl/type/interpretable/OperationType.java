package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationType implements InterpretableType {

    @Autowired
    private TokenSchema operationSchema;

    private final AbstractTokenInterpreter operationInterpreter;

    @Autowired
    public OperationType(AbstractTokenInterpreter operationInterpreter) {

        this.operationInterpreter = operationInterpreter;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return operationInterpreter;
    }

    @Override
    public String getName() {

        return "An operation token";
    }

    @Override
    public TokenSchema getSchema() {

        return operationSchema;
    }
}