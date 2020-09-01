package io.github.mchuhaievskyi.pomidor.syntax.impl.schema.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionSchema extends KeywordSchema {

    @Autowired
    public EndConditionSchema(TokenParser endConditionParser, TokenValidator endConditionValidator) {

        super(endConditionParser, endConditionValidator);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "end\n";
    }
}