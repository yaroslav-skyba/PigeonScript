package io.github.mchuhaievskyi.pomidor.syntax.impl.parser;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.PomidorTokenImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class VarDeclarationTokenParser implements PomidorTokenParser {

    @Autowired
    private PomidorTokenType keywordType;
    @Autowired
    private PomidorTokenType varNameType;
    @Autowired
    private PomidorTokenType operatorType;
    @Autowired
    private PomidorTokenType literalType;
    @Autowired
    private PomidorTokenType varDeclarationType;

    @Override
    public PomidorToken parse(String... sourceCodeTokens) {

        final String sourceCodeLine = String.join(" ", sourceCodeTokens);
        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(keywordType.getSchema().getTokenParser().parse(sourceCodeTokens[0]));
        subTokens.add(varNameType.getSchema().getTokenParser().parse(sourceCodeTokens[1]));
        subTokens.add(operatorType.getSchema().getTokenParser().parse(sourceCodeTokens[2]));
        subTokens.add(literalType.getSchema().getTokenParser().parse(sourceCodeTokens[3]));

        return new PomidorTokenImpl(varDeclarationType, sourceCodeLine, subTokens);
    }
}