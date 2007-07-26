package org.basic.interpreter;

import junit.framework.TestCase;


public class ClosureTest extends TestCase {

    public void testClosureExecution() {
        Closure c = new Closure("add");

        Parameter param1 = new Parameter("val_1", DataType.INTEGER);
        c.addParameter(param1);
        Parameter param2 = new Parameter("val_2", DataType.INTEGER);
        c.addParameter(param2);
        BinaryExpression expr = new BinaryExpression("val_1", "val_2", ArithmeticOperator.ADDITION, new RuntimeEnvironment());
        c.addBody(expr);

        Arguments args = new Arguments();
        args.add("2", "val_1");
        args.add("4", "val_2");

        InvocationResult result = c.eval(args);
        assertEquals("6", result.value());
    }
}
