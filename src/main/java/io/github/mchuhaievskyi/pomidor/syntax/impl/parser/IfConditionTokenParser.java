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
    public PomidorToken parse(String... sourceCodeTokens) {

        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(keywordTokenParser.parse(sourceCodeTokens[0]));

        final int subTokensCount = sourceCodeTokens.length;
        final int keywordSubTokensCount = 2;
        final int expressionSubTokensCount = subTokensCount - keywordSubTokensCount;
        final String[] expressionSubTokens = new String[expressionSubTokensCount];

        System.arraycopy(sourceCodeTokens, 1, expressionSubTokens, 0, expressionSubTokensCount);

        final PomidorToken expressionToken = expressionTokenParser.parse(expressionSubTokens);
        final List<PomidorToken> expressionSubTokensList = expressionToken.getSubTokens();

        subTokens.addAll(expressionSubTokensList);
        subTokens.add(keywordTokenParser.parse(sourceCodeTokens[subTokensCount-1]));

        final String sourceCodeLine = String.join(" ", sourceCodeTokens);

        return new PomidorTokenImpl(ifConditionType, sourceCodeLine, subTokens);
    }
}