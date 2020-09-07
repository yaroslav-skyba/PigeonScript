package io.github.yarunkan.pomidor;

import io.github.yarunkan.pomidor.database.instructions.InstructionsDatabaseImpl;
import io.github.yarunkan.pomidor.syntax.SourceFileReader;
import io.github.yarunkan.pomidor.syntax.impl.*;
import io.github.yarunkan.pomidor.syntax.TokenInterpreter;
import io.github.yarunkan.pomidor.syntax.impl.TokenInterpreterImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        new Main().start(args[0]);
    }

    private void start(String filePath) {

        final SourceFileReader fileReader = new SourceFileReaderImpl(new SourceFileNameValidatorImpl());

        String[] fileLines = new String[0];

        final String redConsoleTextColor = "\033[0;31m";

        try {

            fileLines = fileReader.read(filePath);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            System.out.println(redConsoleTextColor + "Usage: ps <file_path>");
            System.exit(0);
        }

        final ApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackageName());
        final TokenInterpreter interpreter = context.getBean(TokenInterpreterImpl.class);

        for (int i = 0; i < fileLines.length; i++) {

            new InstructionsDatabaseImpl().add(fileLines[i]);

            if (!interpreter.interpret(fileLines[i], context)) {

                System.out.println(redConsoleTextColor + "Line: " + (i+1) + ". An incorrect instruction: " + fileLines[i]);
                System.exit(0);
            }
        }
    }
}