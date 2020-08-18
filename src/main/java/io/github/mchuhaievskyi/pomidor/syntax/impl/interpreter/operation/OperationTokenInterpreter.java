package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperationTokenInterpreter extends PomidorTokenInterpreter {

    private final Set<SpecificOperationTokenInterpreter> specificOperationTokenInterpreters;

    @Autowired
    public OperationTokenInterpreter(Set<SpecificOperationTokenInterpreter> specificOperationTokenInterpreters) {

        this.specificOperationTokenInterpreters = specificOperationTokenInterpreters;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        return specificOperationTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}