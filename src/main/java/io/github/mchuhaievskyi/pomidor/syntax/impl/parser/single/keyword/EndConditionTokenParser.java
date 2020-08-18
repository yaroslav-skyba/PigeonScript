package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single.keyword;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.stereotype.Component;

@Component
public class EndConditionTokenParser extends KeywordTokenParser {

    @Override
    public void setTokenType(PomidorTokenType endConditionType) {

        super.setTokenType(endConditionType);
    }
}