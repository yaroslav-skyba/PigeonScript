package io.github.yarunkan.pomidor.syntax.impl.interpreter.condition;

import io.github.yarunkan.pomidor.syntax.Token;
import io.github.yarunkan.pomidor.syntax.impl.TokenParserImpl;
import io.github.yarunkan.pomidor.syntax.impl.interpreter.expression.SpecificExpressionInterpreter;
import io.github.yarunkan.pomidor.syntax.token.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IfConditionInterpreter extends ConditionInterpreter {

    private Boolean isIfConditionTrue = null;

    @Autowired
    private SpecificExpressionInterpreter<Boolean> boolExpressionInterpreter;
    @Autowired
    private ConditionInterpreter endConditionInterpreter;
    @Autowired
    private TokenType expressionType;

    @Override
    public boolean interpret(Token token) {

        if (isIfConditionTrue != null) {

            throw new IllegalStateException("\"if\" condition is already used");
        }

        final List<Token> subTokens = token.getSubTokens();
        final int expressionTokensOffset = 1;
        final List<Token> expressionTokens = subTokens.subList(expressionTokensOffset, subTokens.size() - expressionTokensOffset);
        final String[] expressionSourceCode = new String[expressionTokens.size()];

        for (int i = 0; i < expressionSourceCode.length; i++) {

            expressionSourceCode[i] = expressionTokens.get(i).getSourceCode();
        }

        final String expressionSourceCodeLine = String.join(" ", expressionSourceCode);
        final Token expressionToken = new TokenParserImpl(expressionSourceCodeLine, expressionType).takeNextToken();

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