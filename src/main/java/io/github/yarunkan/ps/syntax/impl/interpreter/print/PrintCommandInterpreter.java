package io.github.yarunkan.ps.syntax.impl.interpreter.print;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class PrintCommandInterpreter extends AbstractTokenInterpreter {

    private final Set<SpecificPrintCommandInterpreter<?>> specificPrintCommandTokenInterpreters;

    @Autowired
    public PrintCommandInterpreter(Set<SpecificPrintCommandInterpreter<?>> specificPrintCommandTokenInterpreters) {

        this.specificPrintCommandTokenInterpreters = specificPrintCommandTokenInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificPrintCommandTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}