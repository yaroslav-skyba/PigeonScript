package io.github.mchuhaievskyi.pomidor.syntax.impl;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorParser;
import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PomidorParserImpl implements PomidorParser {

    private final PomidorTokenType tokenType;
    private final PomidorTokenValidator tokenValidator;
    private final List<String> sourceCodeTokens = new ArrayList<>();
    private final Iterator<String> sourceCodeTokensIterator;
    private PomidorToken token;

    public PomidorParserImpl(String sourceCode, PomidorTokenType tokenType) {

        this.tokenType = tokenType;
        this.tokenValidator = tokenType.getSchema().getTokenValidator();

        final String tokenParserRegex = "\"([^\"]*)\"|(\\S+)";
        final Matcher tokenParserMatcher = Pattern.compile(tokenParserRegex).matcher(sourceCode);

        while (tokenParserMatcher.find()) {

            sourceCodeTokens.add(tokenParserMatcher.group());
        }

        this.sourceCodeTokensIterator = sourceCodeTokens.iterator();
    }

    private PomidorToken parseNextToken() {

        String[] tokensToPeek = sourceCodeTokens.toArray(new String[0]);

        if (!tokenValidator.validate(tokensToPeek)) {

            // todo: add more reliable error msg
            throw new IllegalStateException("Invalid next token");
        }

        final PomidorTokenParser tokenParser = tokenType.getSchema().getTokenParser();
        return tokenParser.parse(tokensToPeek);
    }

    @Override
    public Optional<PomidorToken> peekNextToken() {

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
    public PomidorToken takeNextToken() {

        if (token == null && sourceCodeTokensIterator.hasNext() && tokenType != null) {

            // todo: add more reliable error msg
            token = peekNextToken().orElseThrow(() -> new IllegalStateException("Can't parse next token"));
        }

        if (token != null) {

            return token;
        }

        return takeNextToken();
    }
}