package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.SingleWordTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeywordTokenParser extends SingleWordTokenParser {

    @Autowired
    @Override
    public void setTokenType(PomidorTokenType keywordType) {

        super.setTokenType(keywordType);
    }
}