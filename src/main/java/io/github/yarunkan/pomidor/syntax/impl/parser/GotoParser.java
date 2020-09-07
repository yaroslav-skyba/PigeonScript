package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.TokenParser;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class GotoParser implements TokenParser {

    private final TokenType gotoType;
    private final TokenParser keywordParser;
    private final TokenParser varNameParser;

    @Autowired
    public GotoParser(@Lazy TokenType gotoType, TokenParser keywordParser, TokenParser varNameParser) {

        this.gotoType = gotoType;
        this.keywordParser = keywordParser;
        this.varNameParser = varNameParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(keywordParser.parse(sourceCodeTokens[0]));
        tokenList.add(varNameParser.parse(sourceCodeTokens[1]));

        return new TokenImpl(gotoType, String.join(" ", sourceCodeTokens), tokenList);
    }
}