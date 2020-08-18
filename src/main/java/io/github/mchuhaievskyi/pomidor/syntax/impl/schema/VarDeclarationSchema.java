package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarDeclarationSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator varDeclarationValidator;
    private final PomidorTokenParser varDeclarationTokenParser;

    @Autowired
    public VarDeclarationSchema(PomidorTokenValidator varDeclarationValidator,
                                PomidorTokenParser varDeclarationTokenParser) {

        this.varDeclarationValidator = varDeclarationValidator;
        this.varDeclarationTokenParser = varDeclarationTokenParser;
    }

    @Override
    public String getDescription() {
        return "10) <var-declaration> --> var <var-name> = <literal>\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {
        return varDeclarationValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {
        return varDeclarationTokenParser;
    }
}