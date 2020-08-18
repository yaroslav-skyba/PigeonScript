package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.condition;

import io.github.mchuhaievskyi.pomidor.syntax.PomidorToken;
import io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter.operation.SpecificOperationTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IfConditionTokenInterpreter extends ConditionTokenInterpreter {

    private Boolean isIfConditionTrue = null;

    @Autowired
    private SpecificOperationTokenInterpreter<Boolean> boolOperationTokenInterpreter;
    @Autowired
    private ConditionTokenInterpreter endConditionTokenInterpreter;

    @Override
    public boolean interpret(PomidorToken token) {

        if (isIfConditionTrue != null) {

            throw new IllegalStateException("\"if\" condition is already used");
        }

        final List<PomidorToken> subTokens = token.getSubTokens();
        final int operandsCount = subTokens.size() / 2;
        final Boolean[] boolOperands = boolOperationTokenInterpreter.getOperands(subTokens, operandsCount, 1);
        final int firstOperationPosition = 2;

        endConditionTokenInterpreter.setIsConditionTrue(null);
        isIfConditionTrue = boolOperationTokenInterpreter.calculateOperands(subTokens, boolOperands, firstOperationPosition);

        return true;
    }

    @Override
    public void setIsConditionTrue(Boolean isConditionTrue) {

        isIfConditionTrue = isConditionTrue;
    }

    @Override
    public Boolean getIsConditionTrue() {

        return isIfConditionTrue;
    }
}