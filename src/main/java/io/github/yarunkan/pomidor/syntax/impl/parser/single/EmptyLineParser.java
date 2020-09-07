package io.github.yarunkan.pomidor.syntax.impl.parser.single;

import io.github.yarunkan.pomidor.syntax.token.TokenType;
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