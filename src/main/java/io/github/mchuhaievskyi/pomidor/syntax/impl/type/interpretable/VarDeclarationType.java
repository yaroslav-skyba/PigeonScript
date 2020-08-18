package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationType implements InterpretableType {

    private final PomidorTokenInterpreter varDeclarationTokenInterpreter;

    @Autowired
    private PomidorTokenSchema varDeclarationSchema;

    @Autowired
    public VarDeclarationType(PomidorTokenInterpreter varDeclarationTokenInterpreter) {

        this.varDeclarationTokenInterpreter = varDeclarationTokenInterpreter;
    }

    @Override
    public String getName() {
        return "Variable declaration token";
    }

    @Override
    public PomidorTokenSchema getSchema() {
        return varDeclarationSchema;
    }

    @Override
    public PomidorTokenInterpreter getInterpreter() {

        return varDeclarationTokenInterpreter;
    }
}