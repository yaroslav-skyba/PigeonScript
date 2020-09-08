package io.github.yarunkan.ps.syntax.impl.parser.single;

import io.github.yarunkan.ps.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class EmptyLineParser extends SingleWordParser {

    @Override
    @Autowired
    public void setTokenType(@Lazy TokenType emptyLineType) {

        super.setTokenType(emptyLineType);
    }
}