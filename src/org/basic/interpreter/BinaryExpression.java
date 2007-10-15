package org.basic.interpreter;

public class BinaryExpression {
    private ArithmeticOperator operator;
    private RuntimeEnvironment env;

    private String leftName;
    private String rightName;

    private int leftValue;
    private int rightValue;

    public BinaryExpression(String fOperand, String sOperand, ArithmeticOperator operator, RuntimeEnvironment env) {
        this.leftName = fOperand;
        this.rightName = sOperand;
        this.operator = operator;
        this.env = env;
    }

    public int eval() {
        return operator.eval(leftValue, rightValue);
    }

    public void bind(Arguments args) {
        leftValue = ((Integer) args.valueOf(leftName));
        rightValue = ((Integer) args.valueOf(rightName));
    }
}
