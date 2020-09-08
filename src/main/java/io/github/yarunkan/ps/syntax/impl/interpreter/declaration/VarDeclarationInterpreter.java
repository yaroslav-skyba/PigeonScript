package io.github.yarunkan.ps.syntax.impl.interpreter.declaration;

import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class VarDeclarationInterpreter extends AbstractTokenInterpreter {

    private final Set<SpecificVarDeclarationInterpreter> specificVarDeclarationInterpreters;

    @Autowired
    public VarDeclarationInterpreter(Set<SpecificVarDeclarationInterpreter> specificVarDeclarationInterpreters) {

        this.specificVarDeclarationInterpreters = specificVarDeclarationInterpreters;
    }

    @Override
    public boolean interpret(Token token) {

        return specificVarDeclarationInterpreters.stream().anyMatch(v -> v.interpret(token));
    }
}