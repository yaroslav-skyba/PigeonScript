package io.github.mchuhaievskyi.pomidor.syntax.impl.parser.single;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperandTokenParser extends SingleWordTokenParser {

    @Autowired
    @Override
    public void setTokenType(PomidorTokenType operandType) {

        super.setTokenType(operandType);
    }
}