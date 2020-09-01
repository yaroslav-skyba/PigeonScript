package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.declaration;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class VarDeclarationInterpreter extends TokenInterpreter {

    private final Set<SpecificVarDeclarationInterpreter> specificVarDeclarationTokenInterpreters;

    @Autowired
    public VarDeclarationInterpreter(Set<SpecificVarDeclarationInterpreter> specificVarDeclarationTokenInterpreters) {

        this.specificVarDeclarationTokenInterpreters = specificVarDeclarationTokenInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificVarDeclarationTokenInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}