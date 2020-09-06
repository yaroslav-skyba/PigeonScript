package io.github.yarunkan.pomidor.syntax.impl;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenParserImpl implements io.github.yarunkan.pomidor.syntax.TokenParser {

    private final TokenType type;
    private final TokenValidator validator;
    private final List<String> sourceCodeTokens = new ArrayList<>();
    private final Iterator<String> sourceCodeTokensIterator;
    private Token token;

    public TokenParserImpl(String sourceCode, TokenType type) {

        this.type = type;
        this.validator = type.getSchema().getTokenValidator();

        final String tokenParserRegex = "\"([^\"]*)\"|(\\S+)";
        final Matcher tokenParserMatcher = Pattern.compile(tokenParserRegex).matcher(sourceCode);

        while (tokenParserMatcher.find()) {

            sourceCodeTokens.add(tokenParserMatcher.group());
        }

        this.sourceCodeTokensIterator = sourceCodeTokens.iterator();
    }

    private Token parseNextToken() {

        String[] tokensToPeek = sourceCodeTokens.toArray(new String[0]);

        if (!validator.validate(tokensToPeek)) {

            // todo: add more reliable error msg
            throw new IllegalStateException("Invalid next token");
        }

        final TokenParser tokenParser = type.getSchema().getTokenParser();

        return tokenParser.parse(tokensToPeek);
    }

    @Override
    public Optional<Token> peekNextToken() {

        if (token != null) {

            // todo: add more reliable error msg
            throw new IllegalStateException("Can't peek next token, token already loaded");
        }

        if (!sourceCodeTokensIterator.hasNext()) {

            // todo: add more reliable error msg
            throw new IllegalStateException("Can't peek next token, end of file");
        }

        token = parseNextToken();

        return Optional.ofNullable(token);
    }

    @Override
    public Token takeNextToken() {

        if (token == null && sourceCodeTokensIterator.hasNext() && type != null) {

            // todo: add more reliable error msg
            token = peekNextToken().orElseThrow(() -> new IllegalStateException("Can't parse next token"));
        }

        if (token != null) {

            return token;
        }

        return takeNextToken();
    }
}