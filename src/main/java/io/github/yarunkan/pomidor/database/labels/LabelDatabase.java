package io.github.yarunkan.pomidor.database.labels;

public interface LabelDatabase {

    void add(String label);
    boolean isPresent(String label);
}