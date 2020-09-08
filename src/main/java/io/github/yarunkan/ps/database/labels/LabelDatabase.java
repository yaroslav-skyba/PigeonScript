package io.github.yarunkan.ps.database.labels;

public interface LabelDatabase {

    void add(String label);
    boolean isPresent(String label);
}