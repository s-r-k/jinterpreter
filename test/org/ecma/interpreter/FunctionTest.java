package org.ecma.interpreter;

import junit.framework.TestCase;


public class FunctionTest extends TestCase {


    public void testFunctionDefinition() {
        Function function = new Function("add");
        Arguments args = new Arguments();
        args.add("a", 10);
        args.add("b", 20);
        function.setArguments(args);
        function.addLocalVariable("result", 0);
    }
}
