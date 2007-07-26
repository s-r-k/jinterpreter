package org.basic.interpreter;

public class InvocationResult {
    private Object value;


    public InvocationResult(Object value) {
        this.value = value;
    }

    public Object value() {
        return value;
    }
}
