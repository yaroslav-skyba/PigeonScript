package io.github.mchuhaievskyi.pomidor.syntax.impl.type;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameType implements PomidorTokenType {

    @Autowired
    private PomidorTokenSchema varNameSchema;

    @Override
    public String getName() {
        return "Variable name token";
    }

    @Override
    public PomidorTokenSchema getSchema() {
        return varNameSchema;
    }
}