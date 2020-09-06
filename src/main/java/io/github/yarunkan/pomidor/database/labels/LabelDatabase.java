package io.github.yarunkan.pomidor.database.labels;

public interface LabelDatabase {

    void add(String instruction);
    boolean isPresent(String instruction);
}