package io.github.yarunkan.pomidor.syntax.impl.interpreter;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineInterpreter extends AbstractTokenInterpreter {

    @Override
    public boolean interpret(Token token) {

        return true;
    }
}