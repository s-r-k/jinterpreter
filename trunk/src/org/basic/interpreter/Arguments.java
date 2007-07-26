package org.basic.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Arguments {
    private Map<String, Object> values = new HashMap<String, Object>();

    public void add(String name, Object value) {
        values.put(name, value);
    }

    public Object valueOf(String name) {
        return values.get(name);
    }
}
