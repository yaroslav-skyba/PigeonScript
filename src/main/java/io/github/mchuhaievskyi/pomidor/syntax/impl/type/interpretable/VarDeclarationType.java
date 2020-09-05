package io.github.mchuhaievskyi.pomidor.syntax.impl.type.interpretable;

import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationType implements InterpretableType {

    private final AbstractTokenInterpreter varDeclarationInterpreter;

    @Autowired
    private TokenSchema varDeclarationSchema;

    @Autowired
    public VarDeclarationType(AbstractTokenInterpreter varDeclarationInterpreter) {

        this.varDeclarationInterpreter = varDeclarationInterpreter;
    }

    @Override
    public String getName() {
        return "Variable declaration token";
    }

    @Override
    public TokenSchema getSchema() {
        return varDeclarationSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return varDeclarationInterpreter;
    }
}