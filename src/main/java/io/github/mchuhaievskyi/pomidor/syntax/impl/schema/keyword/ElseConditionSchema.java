package io.github.mchuhaievskyi.pomidor.syntax.impl.schema.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionSchema extends KeywordSchema {

    @Autowired
    public ElseConditionSchema(PomidorTokenValidator elseConditionValidator, PomidorTokenParser elseConditionTokenParser) {

        super(elseConditionTokenParser, elseConditionValidator);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "else\n";
    }
}