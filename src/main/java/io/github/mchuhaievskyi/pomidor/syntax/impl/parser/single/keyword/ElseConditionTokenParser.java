package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionTokenParser extends KeywordTokenParser {

    @Autowired
    @Override
    public void setTokenType(PomidorTokenType elseConditionType) {

        super.setTokenType(elseConditionType);
    }
}