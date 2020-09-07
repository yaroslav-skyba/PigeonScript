package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineType implements InterpretableType {

    private final AbstractTokenInterpreter emptyLineInterpreter;
    private final TokenSchema emptyLineSchema;

    @Autowired
    public EmptyLineType(AbstractTokenInterpreter emptyLineInterpreter, TokenSchema emptyLineSchema) {

        this.emptyLineInterpreter = emptyLineInterpreter;
        this.emptyLineSchema = emptyLineSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return emptyLineInterpreter;
    }

    @Override
    public String getName() {

        return "An empty line token";
    }

    @Override
    public TokenSchema getSchema() {
        return emptyLineSchema;
    }
}
