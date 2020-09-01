package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperationInterpreter extends TokenInterpreter {

    private final Set<SpecificOperationInterpreter> specificOperationTokenInterpreters;

    @Autowired
    public OperationInterpreter(Set<SpecificOperationInterpreter> specificOperationTokenInterpreters) {

        this.specificOperationTokenInterpreters = specificOperationTokenInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificOperationTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}