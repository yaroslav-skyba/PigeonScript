package io.github.yarunkan.pomidor.database.instructions;

import java.util.List;

public interface InstructionsDatabase {

    void add(String instruction);
    List<String> getInstructionsUnderLabel(String label);
}