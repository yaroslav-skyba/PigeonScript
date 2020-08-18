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
public class OperationTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType operationType;

    private final PomidorTokenParser operandTokenParser;
    private final PomidorTokenParser operatorTokenParser;
    private final PomidorTokenParser expressionTokenParser;

    @Autowired
    public OperationTokenParser(PomidorTokenParser operandTokenParser,
                                PomidorTokenParser operatorTokenParser,
                                PomidorTokenParser expressionTokenParser) {

        this.operandTokenParser = operandTokenParser;
        this.operatorTokenParser = operatorTokenParser;
        this.expressionTokenParser = expressionTokenParser;
    }

    @Override
    public PomidorToken parse(String... sourceCodeTokens) {

        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(operandTokenParser.parse(sourceCodeTokens[0]));
        subTokens.add(operatorTokenParser.parse(sourceCodeTokens[1]));

        final int subTokensCount = sourceCodeTokens.length;
        final int previousSubTokensCount = 2;
        final int expressionSubTokensCount = subTokensCount - previousSubTokensCount;
        final String[] expressionSubTokens = new String[expressionSubTokensCount];

        System.arraycopy(sourceCodeTokens, 2, expressionSubTokens, 0, expressionSubTokensCount);

        final PomidorToken expressionToken = expressionTokenParser.parse(expressionSubTokens);
        final List<PomidorToken> expressionSubTokensList = expressionToken.getSubTokens();

        subTokens.addAll(expressionSubTokensList);

        final String sourceCodeLine = String.join(" ", sourceCodeTokens);

        return new PomidorTokenImpl(operationType, sourceCodeLine, subTokens);
    }
}