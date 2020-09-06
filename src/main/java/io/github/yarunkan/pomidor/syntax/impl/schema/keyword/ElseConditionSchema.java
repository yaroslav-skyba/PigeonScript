package io.github.yarunkan.pomidor.syntax.impl.schema.keyword;

import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionSchema extends KeywordSchema {

    @Autowired
    public ElseConditionSchema(TokenValidator elseConditionValidator, TokenParser elseConditionParser) {

        super(elseConditionParser, elseConditionValidator);
    }

    @Override
    public String getDescription() {

        return super.getDescription() + "else\n";
    }
}