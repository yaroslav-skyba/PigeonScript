package io.github.yarunkan.pomidor.syntax.impl.interpreter.condition;

import io.github.yarunkan.pomidor.syntax.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionInterpreter extends ConditionInterpreter {

    private Boolean isElseConditionTrue = null;

    private final ConditionInterpreter ifConditionInterpreter;

    @Autowired
    public ElseConditionInterpreter(@Lazy ConditionInterpreter ifConditionInterpreter) {

        this.ifConditionInterpreter = ifConditionInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        if (isElseConditionTrue != null) {

            throw new IllegalStateException("\"else\" condition is already used");
        }

        final Boolean isIfConditionTrue = ifConditionInterpreter.getIsConditionTrue();

        if (isIfConditionTrue == null) {

            throw new IllegalStateException("\"else\" condition can`t be used without \"if\" condition");
        }

        if (isIfConditionTrue) {

            isElseConditionTrue = false;

            return true;
        }

        ifConditionInterpreter.setIsConditionTrue(null);
        isElseConditionTrue = true;

        return true;
    }

    @Override
    public void setIsConditionTrue(Boolean isConditionTrue) {

        isElseConditionTrue = isConditionTrue;
    }

    @Override
    public Boolean getIsConditionTrue() {

        return isElseConditionTrue;
    }
}