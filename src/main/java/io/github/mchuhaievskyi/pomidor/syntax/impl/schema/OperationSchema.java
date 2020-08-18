package io.github.mchuhaievskyi.pomidor.syntax.impl.schema;

import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenParser;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenSchema;
import io.github.mchuhaievskyi.pomidor.syntax.token.PomidorTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationSchema implements PomidorTokenSchema {

    private final PomidorTokenValidator operationValidator;
    private final PomidorTokenParser operationTokenParser;

    @Autowired
    public OperationSchema(PomidorTokenValidator operationValidator,
                           PomidorTokenParser operationTokenParser) {

        this.operationValidator = operationValidator;
        this.operationTokenParser = operationTokenParser;
    }

    @Override
    public String getDescription() {

        return "<operation> --> <var-name> = <expression>\n";
    }

    @Override
    public PomidorTokenValidator getTokenValidator() {

        return operationValidator;
    }

    @Override
    public PomidorTokenParser getTokenParser() {

        return operationTokenParser;
    }
}