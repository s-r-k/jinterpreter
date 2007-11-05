package com.eclisp.preter;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 17, 2005
 * Time: 9:20:10 PM
 */
public class PrimitiveLispStatement implements LispStatement {
    protected String statement;


    public PrimitiveLispStatement(String statement) {
        this.statement = statement;

    }

    public Object eval() {
        if(Character.isDigit(lastCharacter()))
            return statement;
        else return Environment.getenv(statement);
    }

    private char lastCharacter() {
        return statement.charAt(statement.length() - 1);
    }

    public String toString() {
        return statement;
    }
}
