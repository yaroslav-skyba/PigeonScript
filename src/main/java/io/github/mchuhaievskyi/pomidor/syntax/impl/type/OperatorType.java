package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorType implements PomidorTokenType {

    @Autowired
    private PomidorTokenSchema operatorSchema;

    @Override
    public String getName() {
        return "Operator token";
    }

    @Override
    public PomidorTokenSchema getSchema() {
        return operatorSchema;
    }
}