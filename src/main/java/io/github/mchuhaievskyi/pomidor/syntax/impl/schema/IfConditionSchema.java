package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IfConditionSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator ifConditionValidator;
    private final PomidorTokenParser ifConditionTokenParser;

    @Autowired
    public IfConditionSchema(PomidorTokenValidator ifConditionValidator,
                             PomidorTokenParser ifConditionTokenParser) {

        this.ifConditionValidator = ifConditionValidator;
        this.ifConditionTokenParser = ifConditionTokenParser;
    }

    @Override
    public String getDescription() {

        return "if <expression> then\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {

        return ifConditionValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {

        return ifConditionTokenParser;
    }
}