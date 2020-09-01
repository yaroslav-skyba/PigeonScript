package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationType implements InterpretableType {

    @Autowired
    private TokenSchema operationSchema;

    private final TokenInterpreter operationInterpreter;

    @Autowired
    public OperationType(TokenInterpreter operationInterpreter) {

        this.operationInterpreter = operationInterpreter;
    }

    @Override
    public TokenInterpreter getInterpreter() {

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