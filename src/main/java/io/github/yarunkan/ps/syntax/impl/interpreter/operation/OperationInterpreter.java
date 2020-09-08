package io.github.yarunkan.ps.syntax.impl.interpreter.operation;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class OperationInterpreter extends AbstractTokenInterpreter {

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