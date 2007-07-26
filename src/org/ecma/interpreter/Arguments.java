package org.ecma.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Arguments {
    private Map<String, Object> all = new HashMap<String, Object>();

    public void add(String param, Object value) {
        all.put(param, value);
    }
}
