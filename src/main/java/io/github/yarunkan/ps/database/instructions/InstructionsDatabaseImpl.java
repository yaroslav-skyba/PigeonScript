package io.github.yarunkan.ps.database.instructions;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InstructionsDatabaseImpl implements InstructionsDatabase {

    private final static List<String> INSTRUCTIONS = new ArrayList<>();

    @Override
    public void add(String instruction) {

        final Matcher tokenMatcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(instruction);

        final List<String> instructionTokens = new ArrayList<>();

        while (tokenMatcher.find()) {

            instructionTokens.add(tokenMatcher.group());
        }

        INSTRUCTIONS.add(String.join(" ", instructionTokens));
    }

    @Override
    public List<String> getInstructionsUnderLabel(String label) {

        return INSTRUCTIONS.subList(INSTRUCTIONS.indexOf(label) + 1, INSTRUCTIONS.size());
    }
}