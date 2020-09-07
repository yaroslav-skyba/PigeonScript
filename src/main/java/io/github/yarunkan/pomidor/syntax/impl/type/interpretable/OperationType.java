package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OperationType implements InterpretableType {

    private final TokenSchema operationSchema;
    private final AbstractTokenInterpreter operationInterpreter;

    @Autowired
    public OperationType(@Lazy TokenSchema operationSchema, AbstractTokenInterpreter operationInterpreter) {

        this.operationInterpreter = operationInterpreter;
        this.operationSchema = operationSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return operationInterpreter;
    }

    @Override
    public String getName() {

        return "An operation token";
    }

    @Override
    public TokenSchema getSchema() {

        return operationSchema;
    }
}