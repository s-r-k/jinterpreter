package org.basic.interpreter;

import junit.framework.TestCase;


public class ClosureTest extends TestCase {

    public void testClosureExecution() {
        Closure c = new Closure("add");

        Parameter param1 = new Parameter("val_1", DataType.INTEGER);
        c.addParameter(param1);

        Parameter param2 = new Parameter("val_2", DataType.INTEGER);
        c.addParameter(param2);

        c.addBody(new Body());

    }
}
