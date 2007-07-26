package org.basic.interpreter;

public class Parameter {
    private String identifier;
    private DataType type;

    public Parameter(String identifier, DataType type) {
        this.identifier = identifier;
        this.type = type;
    }
}
