package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.PSTokenParser;
import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PSTokenParserImpl implements PSTokenParser {

    private final TokenType type;
    private final List<String> sourceCodeTokens = new ArrayList<>();
    private final Iterator<String> sourceCodeTokensIterator;

    private Token token;

    public PSTokenParserImpl(String sourceCode, TokenType type) {

        this.type = type;

        final Matcher parserMatcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(sourceCode);

        while (parserMatcher.find()) {

            sourceCodeTokens.add(parserMatcher.group());
        }

        this.sourceCodeTokensIterator = sourceCodeTokens.iterator();
    }

    private Token parseNextToken() {

        final String[] tokensToPeek = sourceCodeTokens.toArray(new String[0]);

        if (!type.getSchema().getTokenValidator().validate(tokensToPeek)) {

            throw new IllegalStateException("Invalid next token");
        }

        return type.getSchema().getTokenParser().parse(tokensToPeek);
    }

    @Override
    public Optional<Token> peekNextToken() {

        if (token != null) {

            throw new IllegalStateException("Can't peek next token, token already loaded");
        }

        if (!sourceCodeTokensIterator.hasNext()) {

            throw new IllegalStateException("Can't peek next token, end of file");
        }

        token = parseNextToken();

        return Optional.ofNullable(token);
    }

    @Override
    public Token takeNextToken() {

        if (token == null && sourceCodeTokensIterator.hasNext() && type != null) {

            token = peekNextToken().orElseThrow(() -> new IllegalStateException("Can't parse next token"));
        }

        if (token != null) {

            return token;
        }

        return takeNextToken();
    }
}