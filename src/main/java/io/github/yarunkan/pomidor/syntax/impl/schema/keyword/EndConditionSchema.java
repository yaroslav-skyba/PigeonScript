package io.github.yarunkan.pomidor.syntax.impl.schema.keyword;

import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
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