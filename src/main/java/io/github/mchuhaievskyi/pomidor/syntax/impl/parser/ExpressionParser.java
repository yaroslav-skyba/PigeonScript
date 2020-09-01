package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class ExpressionParser implements TokenParser {

    @Autowired
    private TokenType expressionType;

    private final TokenParser operandParser;
    private final TokenParser operatorParser;

    @Autowired
    public ExpressionParser(TokenParser operandParser,
                            TokenParser operatorParser) {

        this.operandParser = operandParser;
        this.operatorParser = operatorParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokensList = new ArrayList<>();

        tokensList.add(operandParser.parse(sourceCodeTokens[0]));

        for (int i = 1; i < sourceCodeTokens.length; i += 2) {

            tokensList.add(operatorParser.parse(sourceCodeTokens[i]));
            tokensList.add(operandParser.parse(sourceCodeTokens[i+1]));
        }

        return new TokenImpl(expressionType, String.join(" ", sourceCodeTokens), tokensList);
    }
}