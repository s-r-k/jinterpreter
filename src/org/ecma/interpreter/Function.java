package org.ecma.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Function {
    private Arguments args;
    private String name;
    private Map<String, Object> localVariables = new HashMap<String, Object>();

    public Function(String name) {
        this.name = name;
    }

    public void setArguments(Arguments arguments) {
        this.args = arguments;
    }

    public void addLocalVariable(String name, Object value) {
        localVariables.put(name, value);
    }
}
