package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElseConditionTokenInterpreter extends ConditionTokenInterpreter {

    private Boolean isElseConditionTrue = null;

    @Autowired
    private ConditionTokenInterpreter ifConditionTokenInterpreter;

    @Override
    public boolean interpret(PomidorToken token) {

        if (isElseConditionTrue != null) {

            throw new IllegalStateException("\"else\" condition is already used");
        }

        final Boolean isIfConditionTrue = ifConditionTokenInterpreter.getIsConditionTrue();

        if (isIfConditionTrue == null) {

            throw new IllegalStateException("\"else\" condition can`t be used without \"if\" condition");
        }

        if (isIfConditionTrue) {

            isElseConditionTrue = false;
            return false;
        }

        ifConditionTokenInterpreter.setIsConditionTrue(null);
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