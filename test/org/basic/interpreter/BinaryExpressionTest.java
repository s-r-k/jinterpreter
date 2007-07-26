package org.basic.interpreter;

import junit.framework.TestCase;

public class BinaryExpressionTest extends TestCase {

    public void testBodyEvaluation() {
        RuntimeEnvironment env = new RuntimeEnvironment();
        BinaryExpression expr = new BinaryExpression("val_1", "val_2", ArithmeticOperator.ADDITION, env);
        Arguments args = new Arguments();
        args.add("val_1", "2");
        args.add("val_2", "4");
        expr.bind(args);
        assertEquals(6, expr.eval());
    }

}
