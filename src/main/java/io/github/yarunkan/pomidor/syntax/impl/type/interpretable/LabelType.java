package io.github.yarunkan.pomidor.syntax.impl.type.interpretable;

import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LabelType implements InterpretableType {

    private final AbstractTokenInterpreter labelInterpreter;
    private final TokenSchema labelSchema;

    @Autowired
    public LabelType(AbstractTokenInterpreter labelInterpreter, @Lazy TokenSchema labelSchema) {

        this.labelInterpreter = labelInterpreter;
        this.labelSchema = labelSchema;
    }

    @Override
    public AbstractTokenInterpreter getInterpreter() {

        return labelInterpreter;
    }

    @Override
    public String getName() {

        return "A label token";
    }

    @Override
    public TokenSchema getSchema() {

        return labelSchema;
    }
}