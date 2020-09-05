package io.github.mchuhaievskyi.pomidor.database.instructions;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class InstructionsDatabaseImpl implements InstructionsDatabase {

    private final static List<String> INSTRUCTIONS = new ArrayList<>();

    @Override
    public void add(String instruction) {

        INSTRUCTIONS.add(instruction);
    }

    @Override
    public List<String> getInstructionsUnderLabel(String label) {

        return INSTRUCTIONS.subList(INSTRUCTIONS.indexOf(label) + 1, INSTRUCTIONS.size());
    }
}