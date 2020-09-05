package io.github.mchuhaievskyi.pomidor.database.labels;

public interface LabelDatabase {

    void add(String instruction);
    boolean isPresent(String instruction);
}