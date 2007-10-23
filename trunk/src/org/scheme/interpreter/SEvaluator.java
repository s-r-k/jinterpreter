package org.scheme.interpreter;

public class SEvaluator {
    private static final String DECIMAL_NUMBER = "\\d+\\.?\\d+";
    private static final String ALPHA_NUMERIC = "\\w+";

    /**
     * Eval takes as arguments an expression and an environment.
     * It classifies the expression and directs its evaluation.
     */
    public Object eval(String expression, GlobalEnvironment root) {
        if (isSelfEvaluating(expression)) return expression;
        return null;
    }

    boolean isSelfEvaluating(String expression) {
        return expression.matches(ALPHA_NUMERIC)
                || expression.matches(DECIMAL_NUMBER);
    }
}
