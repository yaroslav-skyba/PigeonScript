package io.github.yarunkan.pomidor.syntax.impl.interpreter;

import io.github.yarunkan.pomidor.database.labels.LabelDatabase;
import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabelInterpreter extends AbstractTokenInterpreter {

    private final LabelDatabase labelDatabase;

    @Autowired
    public LabelInterpreter(LabelDatabase labelDatabase) {

        this.labelDatabase = labelDatabase;
    }

    @Override
    public boolean interpret(Token token) {

        labelDatabase.add(token.getSubTokens().get(1).getSourceCode());

        return true;
    }
}