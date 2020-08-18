package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionTokenInterpreter extends ConditionTokenInterpreter {

    private Boolean isEndConditionTrue = null;
    private final ConditionTokenInterpreter elseConditionTokenInterpreter;

    @Autowired
    private ConditionTokenInterpreter ifConditionTokenInterpreter;

    @Autowired
    EndConditionTokenInterpreter(ConditionTokenInterpreter elseConditionTokenInterpreter) {

        this.elseConditionTokenInterpreter = elseConditionTokenInterpreter;
    }

    @Override
    public boolean interpret(PomidorToken token) {

        if (isEndConditionTrue != null) {

            throw new IllegalStateException("\"end\" condition is already used");
        }

        if (ifConditionTokenInterpreter.getIsConditionTrue() == null &&
            elseConditionTokenInterpreter.getIsConditionTrue() == null) {

            throw new IllegalStateException("\"end\" condition can`t be used without \"if\" condition");
        }

        ifConditionTokenInterpreter.setIsConditionTrue(null);
        elseConditionTokenInterpreter.setIsConditionTrue(null);
        isEndConditionTrue = true;

        return true;
    }

    @Override
    public void setIsConditionTrue(Boolean isConditionTrue) {

        isEndConditionTrue = isConditionTrue;
    }

    @Override
    public Boolean getIsConditionTrue() {

        return isEndConditionTrue;
    }
}