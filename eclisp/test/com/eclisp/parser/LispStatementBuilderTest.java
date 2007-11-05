package com.eclisp.parser;

import com.eclisp.preter.CompoundLispStatement;
import com.eclisp.preter.LispClauseStatement;
import com.eclisp.preter.PrimitiveLispStatement;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 12, 2005
 * Time: 5:54:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class LispStatementBuilderTest extends TestCase {

	public void testBuildPrimitiveLispStatements() {
		LispStatementBuilder builder = new LispStatementBuilder();
		List statements = builder.buildLispStatements("+ 1 2");
		assertTrue(statements.get(0) instanceof PrimitiveLispStatement);
		assertTrue(statements.get(1) instanceof PrimitiveLispStatement);
		assertTrue(statements.get(2) instanceof PrimitiveLispStatement);
	}

	public void testBuildCompoundLispStatements() {
		LispStatementBuilder builder = new LispStatementBuilder();
		List statements = builder.buildLispStatements("+ (+ 2 (- 5 3)) (abs (4))");
		assertTrue(statements.get(0) instanceof PrimitiveLispStatement);
		assertTrue(statements.get(1) instanceof CompoundLispStatement);
		assertTrue(statements.get(2) instanceof CompoundLispStatement);
	}

	public void testBuildLispClauseStatements() {
		LispStatementBuilder builder = new LispStatementBuilder();
		List statements = builder.buildLispStatements("cond ((> x 0) x) ((= x 0) x)");
		assertTrue(statements.get(0) instanceof PrimitiveLispStatement);
		assertTrue(statements.get(1) instanceof LispClauseStatement);
		assertTrue(statements.get(2) instanceof LispClauseStatement);
	}
}
