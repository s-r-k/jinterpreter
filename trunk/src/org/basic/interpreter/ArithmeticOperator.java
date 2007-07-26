package org.basic.interpreter;

public class ArithmeticOperator {
    public static final ArithmeticOperator ADDITION = new ArithmeticOperator() {

        public int eval(int left, int right) {
            return left + right;
        }
    };

    public int eval(int left, int right) {
        throw new UnsupportedOperationException();
    }
}
