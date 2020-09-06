package io.github.yarunkan.pomidor.syntax.impl.parser.single.keyword;

import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionParser extends KeywordParser {

    @Autowired
    @Override
    public void setTokenType(TokenType elseConditionType) {

        super.setTokenType(elseConditionType);
    }
}