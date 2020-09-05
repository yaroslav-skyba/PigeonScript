package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class LabelParser implements TokenParser {

    @Autowired
    private TokenType labelType;

    private final TokenParser keywordParser;
    private final TokenParser varNameParser;

    @Autowired
    public LabelParser(TokenParser keywordParser, TokenParser varNameParser) {

        this.keywordParser = keywordParser;
        this.varNameParser = varNameParser;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(keywordParser.parse(sourceCodeTokens[0]));
        tokenList.add(varNameParser.parse(sourceCodeTokens[1]));

        return new TokenImpl(labelType, String.join(" ", sourceCodeTokens), tokenList);
    }
}