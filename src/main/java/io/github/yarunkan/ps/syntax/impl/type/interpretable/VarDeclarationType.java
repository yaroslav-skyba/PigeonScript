package io.github.yarunkan.ps.syntax.impl.type.interpretable;

import io.github.yarunkan.ps.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationType implements InterpretableType {

    private final AbstractTokenInterpreter varDeclarationInterpreter;
    private final TokenSchema varDeclarationSchema;

    @Autowired
    public VarDeclarationType(AbstractTokenInterpreter varDeclarationInterpreter, @Lazy TokenSchema varDeclarationSchema) {

        this.varDeclarationInterpreter = varDeclarationInterpreter;
        this.varDeclarationSchema = varDeclarationSchema;
    }

    @Override
    public String getName() {
        return "A variable declaration token";
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