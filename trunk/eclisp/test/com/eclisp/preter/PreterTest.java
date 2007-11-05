package com.eclisp.preter;

import com.eclisp.parser.StatementInterpreter;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:01:49 PM
 */
public class PreterTest extends TestCase {
	StatementInterpreter interpreter;

	protected void setUp() throws Exception {
		interpreter = new StatementInterpreter();
	}

	public void testPrimitiveExpressions() {
		assertEquals("786", interpreter.evaluate(new PrimitiveLispStatement("786")));
	}

	public void testSimpleAdd() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(+ 8 1)"));
		assertEquals("9", result);
	}

	public void testSimpleAddWithMultipleOperands() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(+ 1 4 4)"));
		assertEquals("9", result);
	}

	public void testSimpleSubtract() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(- 9 8)"));
		assertEquals("1", result);
	}

	public void testSimpleMultilpy() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(* 1 8)"));
		assertEquals("8", result);
	}

	public void testSimpleDivide() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(/ 8 8)"));
		assertEquals("1", result);
	}

	public void testCompoundExpression() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(* (+ 1 2) (+ 0 3))"));
		assertEquals("9", result);
	}

	public void testCompoundExpression2() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(* (+ 1 2) (+ 0 3) (* 4 1))"));
		assertEquals("36", result);
	}

	public void testCompoundExpression3() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(* (+ 1 2) (+ (- 5 5) (* 1 3)))"));
		assertEquals("9", result);
	}

	public void testCompoundExpression4() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))"));
		assertEquals("57", result);
	}

	public void testMultipleStatementsTogether() {
		interpreter.evaluate("(define (square x) (* x x))" +
				"(define (abs x)  (cond ((> x 0) x) ((= x 0) x) ((< x 0) (- 0 x))))");
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(square 5)"));
		assertEquals("25", result);
	}

	public void testCompoundExpression5() {
		String result = (String) interpreter.evaluate(new CompoundLispStatement("(+ (+ (* 4 2) 5) (/ 12 6))"));
		assertEquals("15", result);
	}


	public void testLispStatementGroup() {
		interpreter.evaluate("(define (abs x) (cond ((> x 0) x) ((= x 0) x) ((< x 0) (- 0 x))))" +
				"(define (square x) (* x x))" +
				"(define (average a b) (/ (+ a b) 2))" +
				"(define (sqrt x) (sqrt-iter 1 x))" +
				"(define (sqrt-iter guess x) (cond ((good-enough? guess x) guess) ((= 0 0) (sqrt-iter (improve guess x) x))))" +
				"(define (good-enough? guess x) (= (abs (- (square guess) x)) 0))" +
				"(define (improve guess x) (average guess (/ x guess)))");

		assertEquals("3", (String) interpreter.evaluate("(sqrt 9)"));
		assertEquals("2", (String) interpreter.evaluate("(sqrt 4)"));
		assertEquals("4", (String) interpreter.evaluate("(sqrt 16)"));
		assertEquals("5", (String) interpreter.evaluate("(sqrt 25)"));
		assertEquals("7", (String) interpreter.evaluate("(sqrt 49)"));
		assertEquals("9", (String) interpreter.evaluate("(sqrt 81)"));
	}
}
