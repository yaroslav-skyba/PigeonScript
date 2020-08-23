package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class VarDeclarationTokenInterpreter extends PomidorTokenInterpreter {

    private final Set<SpecificVarDeclarationTokenInterpreter> specificVarDeclarationTokenInterpreters;

    @Autowired
    public VarDeclarationTokenInterpreter(Set<SpecificVarDeclarationTokenInterpreter> specificVarDeclarationTokenInterpreters) {

        this.specificVarDeclarationTokenInterpreters = specificVarDeclarationTokenInterpreters;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        return specificVarDeclarationTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}