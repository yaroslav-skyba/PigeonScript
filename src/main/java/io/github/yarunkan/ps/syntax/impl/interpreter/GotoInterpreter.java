package io.github.yarunkan.ps.syntax.impl.interpreter;

import io.github.yarunkan.ps.Main;
import io.github.yarunkan.ps.database.instructions.InstructionsDatabase;
import io.github.yarunkan.ps.syntax.Token;
import io.github.yarunkan.ps.syntax.TokenInterpreter;
import io.github.yarunkan.ps.syntax.impl.TokenInterpreterImpl;
import io.github.yarunkan.ps.syntax.impl.validator.keyword.SpecificKeywordValidator;
import io.github.yarunkan.ps.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GotoInterpreter extends AbstractTokenInterpreter {

    private final InstructionsDatabase instructionsDatabaseImpl;
    private final SpecificKeywordValidator labelKeywordValidator;

    @Autowired
    public GotoInterpreter(InstructionsDatabase instructionsDatabaseImpl, SpecificKeywordValidator labelKeywordValidator) {

        this.instructionsDatabaseImpl = instructionsDatabaseImpl;
        this.labelKeywordValidator = labelKeywordValidator;
    }

    @Override
    public boolean interpret(Token token) {

        final String label = labelKeywordValidator.getKeywordConstant() + " " + token.getSubTokens().get(1).getSourceCode();
        final List<String> instructionListUnderLabel = instructionsDatabaseImpl.getInstructionsUnderLabel(label);

        final ApplicationContext context = new AnnotationConfigApplicationContext(Main.class.getPackageName());
        final TokenInterpreter interpreter = context.getBean(TokenInterpreterImpl.class);

        for (String instructionUnderLabel : instructionListUnderLabel) {

            interpreter.interpret(instructionUnderLabel, context);
        }

        return true;
    }
}