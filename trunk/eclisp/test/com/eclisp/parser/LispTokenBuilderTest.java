package com.eclisp.parser;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 21, 2005
 * Time: 9:58:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class LispTokenBuilderTest extends TestCase {
	public void testBuildTokens() {
		LispTokenBuilder builder = new LispTokenBuilder("+ 1 2");
		assertTrue(builder.isEndOfToken(0));
		assertTrue(builder.isEndOfToken(2));
		assertTrue(builder.isEndOfToken(4));
		List tokens = builder.buildTokens();
		List expectedTokens = new ArrayList();
		expectedTokens.add("+");
		expectedTokens.add("1");
		expectedTokens.add("2");
		assertTokens(expectedTokens, tokens);
	}

	private void assertTokens(List expectedTokens, List tokens) {
		assertEquals(expectedTokens.size(), tokens.size());
		for (int i = 0; i < expectedTokens.size(); i++) {
			assertEquals(expectedTokens.get(i), tokens.get(i));
		}
	}

	public void testBuildTokens2() {
		LispTokenBuilder builder = new LispTokenBuilder("define try 23445");
		assertTrue(builder.isEndOfToken(5));
		assertTrue(builder.isEndOfToken(9));
		assertTrue(builder.isEndOfToken(15));
		List tokens = builder.buildTokens();
		List expectedTokens = new ArrayList();
		expectedTokens.add("define");
		expectedTokens.add("try");
		expectedTokens.add("23445");
		assertTokens(expectedTokens, tokens);
	}

	public void testBuildTokensWithParenthesis() {
		LispTokenBuilder builder = new LispTokenBuilder("+ (+ 2 3) 4");
		assertTrue(builder.isEndOfToken(0));
		assertTrue(builder.isEndOfToken(8));
		assertTrue(builder.isEndOfToken(10));
		List tokens = builder.buildTokens();
		List expectedTokens = new ArrayList();
		expectedTokens.add("+");
		expectedTokens.add("(+ 2 3)");
		expectedTokens.add("4");
		assertTokens(expectedTokens, tokens);
	}

	public void testBuildTokensWithParenthesis2() {
		LispTokenBuilder builder = new LispTokenBuilder("+ (+ 2 (- 5 3)) (abs (4))");
		assertTrue(builder.isEndOfToken(0));
		assertTrue(builder.isEndOfToken(8));
		assertTrue(builder.isEndOfToken(10));
		List tokens = builder.buildTokens();
		List expectedTokens = new ArrayList();
		expectedTokens.add("+");
		expectedTokens.add("(+ 2 (- 5 3))");
		expectedTokens.add("(abs (4))");
		assertTokens(expectedTokens, tokens);
	}
//todo: test for  ( () ) condition ;-)
}
