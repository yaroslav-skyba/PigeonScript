package io.github.yarunkan.ps.syntax.impl.parser.single.keyword;

import io.github.yarunkan.ps.syntax.impl.parser.single.SingleWordParser;
import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordParser extends SingleWordParser {

    @Autowired
    @Override
    public void setTokenType(TokenType keywordType) {

        super.setTokenType(keywordType);
    }
}