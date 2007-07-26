package org.basic.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Closure {
    private String name;
    private List<Parameter> params = new ArrayList<Parameter>();

    public Closure(String name) {
        this.name = name;
    }


    public void addParameter(Parameter p) {
        params.add(p);
    }

    public void addBody(Body body) {

    }
}
