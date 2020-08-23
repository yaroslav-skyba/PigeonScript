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
    private PomidorTokenType expressionType;
    @Autowired
    private PomidorTokenType varDeclarationType;

    @Override
    public PomidorToken parse(String... tokens) {

        final String sourceCodeLine = String.join(" ", tokens);
        final List<PomidorToken> subTokens = new ArrayList<>();

        subTokens.add(keywordType.getSchema().getTokenParser().parse(tokens[0]));
        subTokens.add(varNameType.getSchema().getTokenParser().parse(tokens[1]));
        subTokens.add(operatorType.getSchema().getTokenParser().parse(tokens[2]));
        subTokens.add(expressionType.getSchema().getTokenParser().parse(tokens[3]));

        return new PomidorTokenImpl(varDeclarationType, sourceCodeLine, subTokens);
    }
}