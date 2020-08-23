package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class IfConditionTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType ifConditionType;

    private final PomidorTokenParser keywordTokenParser;
    private final PomidorTokenParser expressionTokenParser;

    @Autowired
    public IfConditionTokenParser(PomidorTokenParser keywordTokenParser,
                                  PomidorTokenParser expressionTokenParser) {

        this.keywordTokenParser = keywordTokenParser;
        this.expressionTokenParser = expressionTokenParser;
    }

    @Override
    public PomidorToken parse(String... tokens) {

        final List<PomidorToken> ifConditionTokens = new ArrayList<>();
        ifConditionTokens.add(keywordTokenParser.parse(tokens[0]));

        final int tokensCount = tokens.length;
        final int expressionTokensCount = tokensCount - 2;
        final String[] expressionTokens = new String[expressionTokensCount];

        final int expressionTokensOffset = 1;
        System.arraycopy(tokens, expressionTokensOffset, expressionTokens, 0, expressionTokensCount);

        final List<PomidorToken> parsedExpressionTokens = expressionTokenParser.parse(expressionTokens).getSubTokens();
        ifConditionTokens.addAll(parsedExpressionTokens);
        ifConditionTokens.add(keywordTokenParser.parse(tokens[tokensCount - expressionTokensOffset]));

        final String sourceCodeLine = String.join(" ", tokens);

        return new PomidorTokenImpl(ifConditionType, sourceCodeLine, ifConditionTokens);
    }
}