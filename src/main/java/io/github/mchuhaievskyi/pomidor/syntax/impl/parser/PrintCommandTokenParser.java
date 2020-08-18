package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class PrintCommandTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType printCommandType;
    @Autowired
    private PomidorTokenParser keywordTokenParser;

    private final PomidorTokenParser operandTokenParser;

    @Autowired
    public PrintCommandTokenParser(PomidorTokenParser operandTokenParser) {

        this.operandTokenParser = operandTokenParser;
    }

    @Override
    public PomidorToken parse(String... sourceCodeTokens) {

        final String sourceCodeLine = String.join(" ", sourceCodeTokens);
        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(keywordTokenParser.parse(sourceCodeTokens[0]));
        subTokens.add(operandTokenParser.parse(sourceCodeTokens[1]));

        return new PomidorTokenImpl(printCommandType, sourceCodeLine, subTokens);
    }
}