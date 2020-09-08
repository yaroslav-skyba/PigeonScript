package io.github.yarunkan.ps.syntax.impl.type;

import io.github.yarunkan.ps.syntax.token.TokenSchema;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OperatorType implements TokenType {

    private final TokenSchema operatorSchema;

    @Autowired
    @Lazy
    public OperatorType(TokenSchema operatorSchema) {

        this.operatorSchema = operatorSchema;
    }

    @Override
    public String getName() {
        return "A operator token";
    }

    @Override
    public TokenSchema getSchema() {
        return operatorSchema;
    }
}