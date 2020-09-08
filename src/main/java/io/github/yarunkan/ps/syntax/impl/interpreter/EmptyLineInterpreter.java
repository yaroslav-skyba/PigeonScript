package io.github.yarunkan.ps.syntax.impl.interpreter;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineInterpreter extends AbstractTokenInterpreter {

    @Override
    public boolean interpret(Token token) {

        return true;
    }
}