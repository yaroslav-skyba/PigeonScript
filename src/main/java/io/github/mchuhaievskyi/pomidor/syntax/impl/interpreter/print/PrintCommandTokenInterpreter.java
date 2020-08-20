package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.print;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class PrintCommandTokenInterpreter extends PomidorTokenInterpreter {

    private final Set<SpecificPrintCommandTokenInterpreter> specificPrintCommandTokenInterpreters;

    @Autowired
    public PrintCommandTokenInterpreter(Set<SpecificPrintCommandTokenInterpreter> specificPrintCommandTokenInterpreters) {

        this.specificPrintCommandTokenInterpreters = specificPrintCommandTokenInterpreters;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        return specificPrintCommandTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}