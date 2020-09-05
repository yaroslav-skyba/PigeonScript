package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.SingleWordParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
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