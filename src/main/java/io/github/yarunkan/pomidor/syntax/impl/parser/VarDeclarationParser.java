package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class VarDeclarationParser implements TokenParser {

    private final TokenType keywordType;
    private final TokenType varNameType;
    private final TokenType operatorType;
    private final TokenType expressionType;
    private final TokenType varDeclarationType;

    @Autowired
    @Lazy
    public VarDeclarationParser(TokenType keywordType,
                                TokenType varNameType,
                                TokenType operatorType,
                                TokenType expressionType,
                                TokenType varDeclarationType) {

        this.keywordType = keywordType;
        this.varNameType = varNameType;
        this.operatorType = operatorType;
        this.expressionType = expressionType;
        this.varDeclarationType = varDeclarationType;
    }

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokenList = new ArrayList<>();

        tokenList.add(keywordType.getSchema().getTokenParser().parse(sourceCodeTokens[0]));
        tokenList.add(varNameType.getSchema().getTokenParser().parse(sourceCodeTokens[1]));
        tokenList.add(operatorType.getSchema().getTokenParser().parse(sourceCodeTokens[2]));

        final int notExpressionTokensCount = 3;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokenList.addAll(expressionType.getSchema().getTokenParser().parse(expressionTokens).getSubTokens());

        return new TokenImpl(varDeclarationType, String.join(" ", sourceCodeTokens), tokenList);
    }
}