package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class PrintCommandInterpreter extends TokenInterpreter {

    private final Set<SpecificPrintCommandInterpreter> specificPrintCommandTokenInterpreters;

    @Autowired
    public PrintCommandInterpreter(Set<SpecificPrintCommandInterpreter> specificPrintCommandTokenInterpreters) {

        this.specificPrintCommandTokenInterpreters = specificPrintCommandTokenInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificPrintCommandTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}