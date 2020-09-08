package io.github.yarunkan.ps.syntax.impl.parser.single.keyword;

import io.github.yarunkan.ps.syntax.token.TokenType;
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