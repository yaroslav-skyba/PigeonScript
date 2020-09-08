package io.github.yarunkan.ps.syntax.impl.parser.single;

import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VarNameParser extends SingleWordParser {

    @Autowired
    @Override
    public void setTokenType(TokenType varNameType) {
        super.setTokenType(varNameType);
    }
}