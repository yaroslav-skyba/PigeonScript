package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationType implements InterpretableType {

    @Autowired
    private PomidorTokenSchema operationSchema;

    private final PomidorTokenInterpreter operationTokenInterpreter;

    @Autowired
    public OperationType(PomidorTokenInterpreter operationTokenInterpreter) {

        this.operationTokenInterpreter = operationTokenInterpreter;
    }

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return operationTokenInterpreter;
    }

    @Override
    public String getName() {

        return "An operation token";
    }

    @Override
    public PomidorTokenSchema getSchema() {

        return operationSchema;
    }
}