package io.github.mchuhaievskyi.pomidor.syntax.impl.schema.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionSchema extends KeywordSchema {

    @Autowired
    public EndConditionSchema(PomidorTokenParser endConditionTokenParser, PomidorTokenValidator endConditionValidator) {

        super(endConditionTokenParser, endConditionValidator);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "end\n";
    }
}