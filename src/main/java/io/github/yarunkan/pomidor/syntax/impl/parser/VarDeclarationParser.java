package io.github.yarunkan.pomidor.syntax.impl.parser;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenImpl;
import io.github.yarunkan.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class VarDeclarationParser implements TokenParser {

    @Autowired
    private TokenType keywordType;
    @Autowired
    private TokenType varNameType;
    @Autowired
    private TokenType operatorType;
    @Autowired
    private TokenType expressionType;
    @Autowired
    private TokenType varDeclarationType;

    @Override
    public Token parse(String... sourceCodeTokens) {

        final List<Token> tokensList = new ArrayList<>();

        tokensList.add(keywordType.getSchema().getTokenParser().parse(sourceCodeTokens[0]));
        tokensList.add(varNameType.getSchema().getTokenParser().parse(sourceCodeTokens[1]));
        tokensList.add(operatorType.getSchema().getTokenParser().parse(sourceCodeTokens[2]));

        final int notExpressionTokensCount = 3;
        final int expressionTokensCount = sourceCodeTokens.length - notExpressionTokensCount;
        final String[] expressionTokens = new String[expressionTokensCount];

        System.arraycopy(sourceCodeTokens, notExpressionTokensCount, expressionTokens, 0, expressionTokensCount);

        tokensList.addAll(expressionType.getSchema().getTokenParser().parse(expressionTokens).getSubTokens());

        return new TokenImpl(varDeclarationType, String.join(" ", sourceCodeTokens), tokensList);
    }
}