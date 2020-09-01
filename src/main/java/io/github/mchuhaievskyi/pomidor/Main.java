package io.github.mchuhaievskyi.pomidor;

import io.github.mchuhaievskyi.pomidor.syntax.SourceFileReader;
import io.github.mchuhaievskyi.pomidor.syntax.impl.*;
import io.github.mchuhaievskyi.pomidor.syntax.TokenInterpreter;
import io.github.mchuhaievskyi.pomidor.syntax.impl.TokenInterpreterImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private final static String RED_CONSOLE_TEXT_COLOR = "\033[0;31m";

    public static void main(String[] args) {

        new Main().start(args[0]);
    }

    private void start(String filePath) {

        final SourceFileReader fileReader = new SourceFileReaderImpl(new SourceFileNameValidatorImpl());
        String[] fileLines = new String[0];

        try {

            fileLines = fileReader.read(filePath);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            System.out.println(RED_CONSOLE_TEXT_COLOR + "Usage: pomidor <file_path>");
            System.exit(0);
        }

        final ApplicationContext context = new AnnotationConfigApplicationContext(this.getClass().getPackageName());
        final TokenInterpreter interpreter = context.getBean(TokenInterpreterImpl.class);

        for (int i = 0; i < fileLines.length; i++) {

            if (!interpreter.interpret(fileLines[i], context)) {

                System.out.println(RED_CONSOLE_TEXT_COLOR + "Line: " + (i+1) + ". An incorrect instruction: " + fileLines[i]);
                System.exit(0);
            }
        }
    }
}