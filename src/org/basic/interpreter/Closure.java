package org.basic.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Closure {
    private String name;
    private List<Parameter> params = new ArrayList<Parameter>();
    private BinaryExpression body;

    public Closure(String name) {
        this.name = name;
    }

    public void addParameter(Parameter p) {
        params.add(p);
    }

    public void addBody(BinaryExpression expression) {
        body = expression;
    }

    public InvocationResult eval(Arguments args) {
        body.bind(args);
        return new InvocationResult(body.eval());
    }
}
