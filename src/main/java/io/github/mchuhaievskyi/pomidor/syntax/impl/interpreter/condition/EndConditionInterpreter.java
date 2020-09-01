package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

import io.github.mchuhaievskyi.pomidor.syntax.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EndConditionInterpreter extends ConditionInterpreter {

    private Boolean isEndConditionTrue = null;
    private final ConditionInterpreter elseConditionInterpreter;

    @Autowired
    private ConditionInterpreter ifConditionInterpreter;

    @Autowired
    public EndConditionInterpreter(ConditionInterpreter elseConditionInterpreter) {

        this.elseConditionInterpreter = elseConditionInterpreter;
    }

    @Override
    public boolean interpret(Token token) {

        if (isEndConditionTrue != null) {

            throw new IllegalStateException("\"end\" condition is already used");
        }

        if (ifConditionInterpreter.getIsConditionTrue() == null && elseConditionInterpreter.getIsConditionTrue() == null) {

            throw new IllegalStateException("\"end\" condition can`t be used without \"if\" condition");
        }

        ifConditionInterpreter.setIsConditionTrue(null);
        elseConditionInterpreter.setIsConditionTrue(null);
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