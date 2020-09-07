package io.github.yarunkan.pomidor.syntax.impl.interpreter.condition;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.PSTokenParserImpl;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IfConditionInterpreter extends ConditionInterpreter {

    private Boolean isIfConditionTrue = null;

    private final SpecificExpressionInterpreter<Boolean> boolExpressionInterpreter;
    private final ConditionInterpreter endConditionInterpreter;
    private final TokenType expressionType;

    @Lazy
    @Autowired
    public IfConditionInterpreter(SpecificExpressionInterpreter<Boolean> boolExpressionInterpreter,
                                  ConditionInterpreter endConditionInterpreter,
                                  TokenType expressionType) {

        this.boolExpressionInterpreter = boolExpressionInterpreter;
        this.endConditionInterpreter = endConditionInterpreter;
        this.expressionType = expressionType;
    }

    @Override
    public boolean interpret(Token token) {

        if (isIfConditionTrue != null) {

            throw new IllegalStateException("\"if\" condition is already used");
        }

        final List<Token> subTokens = token.getSubTokens();

        final int expressionTokensOffset = 1;
        final List<Token> expressionTokens = subTokens.subList(expressionTokensOffset, subTokens.size() - expressionTokensOffset);
        final String[] expressionSourceCodeTokens = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCodeTokens.length; i++) {

            expressionSourceCodeTokens[i] = expressionTokens.get(i).getSourceCode();
        }

        final Token expressionToken = new PSTokenParserImpl(String.join(" ", expressionSourceCodeTokens), expressionType).takeNextToken();

        if (!boolExpressionInterpreter.interpret(expressionToken)) {

            return false;
        }

        try {

            isIfConditionTrue = boolExpressionInterpreter.getExpressionResult(expressionToken);

        } catch (Exception e) {

            return false;
        }

        endConditionInterpreter.setIsConditionTrue(null);

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