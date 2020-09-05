package io.github.mchuhaievskyi.pomidor.syntax.impl.interpreter;

import io.github.mchuhaievskyi.pomidor.Main;
import io.github.mchuhaievskyi.pomidor.database.instructions.InstructionsDatabase;
import io.github.mchuhaievskyi.pomidor.syntax.Token;
import io.github.mchuhaievskyi.pomidor.syntax.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenInterpreterImpl;
import io.github.mchuhaievskyi.pomidor.syntax.token.AbstractTokenInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GotoInterpreter extends AbstractTokenInterpreter {

    private final InstructionsDatabase instructionsDatabaseImpl;

    @Autowired
    public GotoInterpreter(InstructionsDatabase instructionsDatabaseImpl) {

        this.instructionsDatabaseImpl = instructionsDatabaseImpl;
    }

    @Override
    public boolean interpret(Token token) {

        final List<String> instructionListUnderLabel = instructionsDatabaseImpl.getInstructionsUnderLabel("label " + token.getSubTokens().get(1).getSourceCode() + "\r");

        final ApplicationContext context = new AnnotationConfigApplicationContext(Main.class.getPackageName());
        final TokenInterpreter interpreter = context.getBean(TokenInterpreterImpl.class);

        for (String instructionUnderLabel : instructionListUnderLabel) {

            interpreter.interpret(instructionUnderLabel, context);
        }

        return true;
    }
}