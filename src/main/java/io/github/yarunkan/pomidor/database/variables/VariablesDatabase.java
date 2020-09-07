package io.github.yarunkan.pomidor.database.variables;

public interface VariablesDatabase {

    String get(String variableName);
    void add(String variableName, String variableValue);
}