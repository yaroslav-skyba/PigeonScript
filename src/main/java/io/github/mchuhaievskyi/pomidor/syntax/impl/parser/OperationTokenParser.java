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
    public PomidorToken parse(String... tokens) {

        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(operandTokenParser.parse(tokens[0]));
        subTokens.add(operatorTokenParser.parse(tokens[1]));

        final int subTokensCount = tokens.length;
        final int previousSubTokensCount = 2;
        final int expressionSubTokensCount = subTokensCount - previousSubTokensCount;
        final String[] expressionSubTokens = new String[expressionSubTokensCount];

        System.arraycopy(tokens, previousSubTokensCount, expressionSubTokens, 0, expressionSubTokensCount);

        final PomidorToken expressionToken = expressionTokenParser.parse(expressionSubTokens);
        final List<PomidorToken> expressionSubTokensList = expressionToken.getSubTokens();

        subTokens.addAll(expressionSubTokensList);

        final String sourceCodeLine = String.join(" ", tokens);

        return new PomidorTokenImpl(operationType, sourceCodeLine, subTokens);
    }
}