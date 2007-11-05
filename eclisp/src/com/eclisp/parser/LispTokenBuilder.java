package com.eclisp.parser;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 21, 2005
 * Time: 9:55:30 PM
 * To change this template use File | Settings | File Templates.
 */
class LispTokenBuilder {
	private String statement;
	private char[] chars;
	private Stack parenthesisStack;

	public LispTokenBuilder(String statement) {
		this.statement = statement;
		parenthesisStack = new Stack();
		setUp();
	}

	List<String> buildTokens() {
		cleanup();
		setUp();
		return tokenize();
	}

	private List<String> tokenize() {
		List<String> tokens = new ArrayList<String>();
		int currentTokenStart = 0;
		for (int currentPos = 0; currentPos < chars.length; currentPos++) {
			if (isEndOfToken(currentPos)) {
				tokens.add(statement.substring(currentTokenStart, currentPos + 1).trim());
				currentTokenStart = currentPos + 1;
			}
			handleStack(currentPos);
		}
		return tokens;
	}

	private void setUp() {
		chars = this.statement.toCharArray();
	}

	private void cleanup() {
		statement = statement.replaceAll("  ", " ").trim();
		if (statement.trim().charAt(0) == '(')
			statement = statement.substring(1, statement.length() - 1).trim();
	}

	List buildStatements(){
		setUp();
		return tokenize();
	}

	private void handleStack(int currentPos) {
		if (chars[currentPos] == '(') {
			parenthesisStack.push("(");
		} else if (chars[currentPos] == ')') {
			parenthesisStack.pop();
		}
	}

	//todo: can be improved
	boolean isEndOfToken(int currentPos) {
		if (currentPos == chars.length - 1)
			return true;
		if (chars[currentPos] == ')' && parenthesisStack.size() == 1)
			return true;
		if (chars[currentPos] == ')' && parenthesisStack.size() > 1)
			return false;
		if (chars[currentPos] != ')' && !parenthesisStack.isEmpty())
			return false;
		if (chars[currentPos + 1] == ' ')
			return true;
		return false;
	}
}
