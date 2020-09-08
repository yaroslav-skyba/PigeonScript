package io.github.yarunkan.ps.syntax.impl.parser.single;

import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiteralParser extends SingleWordParser {

    @Autowired
    @Override
    public void setTokenType(TokenType literalType) {

        super.setTokenType(literalType);
    }
}