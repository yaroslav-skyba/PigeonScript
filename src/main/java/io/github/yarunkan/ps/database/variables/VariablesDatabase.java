package io.github.yarunkan.ps.database.variables;

public interface VariablesDatabase {

    String get(String variableName);
    void add(String variableName, String variableValue);
}