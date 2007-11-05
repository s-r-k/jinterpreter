package com.eclisp.parser;

import com.eclisp.preter.CompoundLispStatement;
import com.eclisp.preter.LispClauseStatement;
import com.eclisp.preter.LispStatement;
import com.eclisp.preter.PrimitiveLispStatement;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 12, 2005
 * Time: 6:35:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LispStatementBuilder {

	public List<LispStatement> buildLispStatements(String statement) {
		List<LispStatement> statements = new ArrayList<LispStatement>();
		List<String> tokens = new LispTokenBuilder(statement).buildTokens();
		for(String token : tokens){
			if (isPrimitive(token))
				statements.add(new PrimitiveLispStatement(token));
			else if (isClause(token))
				statements.add(new LispClauseStatement(token));
			else
				statements.add(new CompoundLispStatement(token));
		}
		return statements;
	}

	private boolean isClause(String token) {
		List list = new LispTokenBuilder(token).buildTokens();
		return list.size() == 2 && !isPrimitive((String) list.get(0));
	}

	private boolean isPrimitive(String token) {
		return token.indexOf("(") == -1;
	}
}
