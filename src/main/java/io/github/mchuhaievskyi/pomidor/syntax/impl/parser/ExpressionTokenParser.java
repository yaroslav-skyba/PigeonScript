package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class ExpressionTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType expressionType;

    private final PomidorTokenParser operandTokenParser;
    private final PomidorTokenParser operatorTokenParser;

    @Autowired
    public ExpressionTokenParser(PomidorTokenParser operandTokenParser,
                                 PomidorTokenParser operatorTokenParser) {

        this.operandTokenParser = operandTokenParser;
        this.operatorTokenParser = operatorTokenParser;
    }

    @Override
    public PomidorToken parse(String... sourceCodeTokens) {

        final int sourceCodeTokensLength = sourceCodeTokens.length;
        final String sourceCodeLine = String.join(" ", sourceCodeTokens);
        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(operandTokenParser.parse(sourceCodeTokens[0]));

        for (int i = 1; i < sourceCodeTokensLength; i += 2) {

            subTokens.add(operatorTokenParser.parse(sourceCodeTokens[i]));
            subTokens.add(operandTokenParser.parse(sourceCodeTokens[i+1]));
        }

        return new PomidorTokenImpl(expressionType, sourceCodeLine, subTokens);
    }
}