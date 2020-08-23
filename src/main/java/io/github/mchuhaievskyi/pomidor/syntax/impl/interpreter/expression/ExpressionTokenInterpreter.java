package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.expression;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ExpressionTokenInterpreter extends PomidorTokenInterpreter {

    private final Set<SpecificExpressionTokenInterpreter> specificExpressionTokenInterpreters;

    @Autowired
    public ExpressionTokenInterpreter(Set<SpecificExpressionTokenInterpreter> specificExpressionTokenInterpreters) {

        this.specificExpressionTokenInterpreters = specificExpressionTokenInterpreters;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        return specificExpressionTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}