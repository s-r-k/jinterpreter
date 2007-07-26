package org.basic.interpreter;

public class BinaryExpression {
    private String left;
    private String right;
    private ArithmeticOperator operator;
    private RuntimeEnvironment env;

    public BinaryExpression(String left, String right, ArithmeticOperator operator, RuntimeEnvironment env) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.env = env;
    }
}
