package io.github.yarunkan.ps.syntax.impl.parser.single.keyword;

import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.stereotype.Component;

@Component
public class EndConditionParser extends KeywordParser {

    @Override
    public void setTokenType(TokenType endConditionType) {

        super.setTokenType(endConditionType);
    }
}