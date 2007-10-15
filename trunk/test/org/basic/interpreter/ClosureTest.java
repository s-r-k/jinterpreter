package org.basic.interpreter;

import junit.framework.TestCase;


public class ClosureTest extends TestCase {

    public void testClosureExecutionWithIntegers() {
        Closure c = new Closure("add");

        Parameter param1 = new Parameter("val_1", DataType.INTEGER);
        c.addParameter(param1);
        Parameter param2 = new Parameter("val_2", DataType.INTEGER);
        c.addParameter(param2);
        BinaryExpression expr = new BinaryExpression("val_1", "val_2", ArithmeticOperator.ADDITION, new RuntimeEnvironment());
        c.addBody(expr);

        Arguments args = new Arguments();
        args.add("val_1", 2);
        args.add("val_2", 4);

        InvocationResult result = c.eval(args);
        assertEquals(6, result.value());
    }

    public void testClosureExecutionWithFloats() {
        Closure c = new Closure("add");

        Parameter param1 = new Parameter("val_1", DataType.NUMBER);
        c.addParameter(param1);
        Parameter param2 = new Parameter("val_2", DataType.NUMBER);
        c.addParameter(param2);
        BinaryExpression expr = new BinaryExpression("val_1", "val_2", ArithmeticOperator.ADDITION, new RuntimeEnvironment());
        c.addBody(expr);

        Arguments args = new Arguments();
        args.add("val_1", 6.4);
        args.add("val_2", 3.6);

        InvocationResult result = c.eval(args);
        assertEquals(10.0, result.value());
    }


}
