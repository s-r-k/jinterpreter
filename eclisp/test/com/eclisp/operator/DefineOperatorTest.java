package com.eclisp.operator;

import junit.framework.TestCase;
import com.eclisp.preter.CompoundLispStatement;
import com.eclisp.preter.Environment;
import com.eclisp.parser.StatementInterpreter;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:01:49 PM
 */
public class DefineOperatorTest extends TestCase {
    StatementInterpreter interpreter;

    protected void setUp() throws Exception {
        interpreter = new StatementInterpreter();
    }

    public void testDefine() {
        interpreter.evaluate(new CompoundLispStatement("(define size 2)"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(+ 1 size)"));
        assertEquals("3", result);
        result = (String) interpreter.evaluate(new CompoundLispStatement("(- 3 size)"));
        assertEquals("1", result);
    }

    public void testMultipleLevelOfDefinition() {
        interpreter.evaluate(new CompoundLispStatement("(define pi 3)"));
        interpreter.evaluate(new CompoundLispStatement("(define radius 10)"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(* pi (* radius radius))"));
        assertEquals("300", result);
    }

    public void testDefineProcedure() {
        interpreter.evaluate(new CompoundLispStatement("(define (square x) (* x x))"));
        Environment.dump();
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(square (+ 1 (- 6 2)))"));
        assertEquals("25", result);
        result = (String) interpreter.evaluate(new CompoundLispStatement("(square 5)"));
        assertEquals("25", result);
        result = (String) interpreter.evaluate(new CompoundLispStatement("(square (square 3))"));
        assertEquals("81", result);

        Environment.dump();
    }

    public void testProceduresWithMultipleArgs() {
        interpreter.evaluate(new CompoundLispStatement("(define (square x) (* x x))"));
        interpreter.evaluate(new CompoundLispStatement("(define (sum-of-squares x y) (+ (square x) (square y)))"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(sum-of-squares 3 4)"));
        assertEquals("25", result);
    }

    public void testCondition() {
        interpreter.evaluate(new CompoundLispStatement("(define (abs x)  (cond ((> x 0) x) ((< x 0) 0)))"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(abs 5)"));
        assertEquals("5", result);
    }

    public void testCondition2() {
        interpreter.evaluate(new CompoundLispStatement("(define (abs x)  (cond ((> x 0) x) ((< x 0) 0)))"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(abs -3)"));
        assertEquals("0", result);
    }

    public void testCondition3() {
        interpreter.evaluate(new CompoundLispStatement("(define (abs x)  (cond ((and (> x 0) (< x 5)) x) ((< x 0) 0)))"));
        String result = (String) interpreter.evaluate(new CompoundLispStatement("(abs -3)"));
        assertEquals("0", result);
    }

	public void testMultipleStatements() {
		interpreter.evaluate(new CompoundLispStatement("(define (abs x)  (cond ((> x 0) x) ((= x 0) x) ((< x 0) (- 0 x))))"));

		interpreter.evaluate(new CompoundLispStatement("(define (square x) (* x x))"));

		interpreter.evaluate(new CompoundLispStatement("(define (average a b) (/ (+ a b) 2))"));

		interpreter.evaluate(new CompoundLispStatement("(define (sqrt x) (sqrt-iter 1 x))"));

		interpreter.evaluate(new CompoundLispStatement("(define (sqrt-iter guess x) (cond ((good-enough? guess x) guess) ((= 0 0) (sqrt-iter (improve guess x) x))))"));

		interpreter.evaluate(new CompoundLispStatement("(define (good-enough? guess x) (= (abs (- (square guess) x)) 0))"));

		interpreter.evaluate(new CompoundLispStatement("(define (improve guess x) (average guess (/ x guess)))"));

		String result = (String) interpreter.evaluate(new CompoundLispStatement("(sqrt 9)"));
		System.out.println("result = " + result);

	}

}
