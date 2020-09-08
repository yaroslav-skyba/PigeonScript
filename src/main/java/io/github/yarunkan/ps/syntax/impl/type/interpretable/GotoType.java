package io.github.yarunkan.ps.syntax.impl.type.interpretable;

import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.ps.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GotoType implements InterpretableType {

    private final AbstractTokenInterpreter gotoInterpreter;
    private final TokenSchema gotoSchema;

    @Autowired
    public GotoType(AbstractTokenInterpreter gotoInterpreter, TokenSchema gotoSchema) {

        this.gotoInterpreter = gotoInterpreter;
        this.gotoSchema = gotoSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return gotoInterpreter;
    }

    @Override
    public String getName() {

        return "A goto token";
    }

    @Override
    public TokenSchema getSchema() {

        return gotoSchema;
    }
}