package org.ecma.interpreter;

import junit.framework.TestCase;

/**
 * var i = 10;
 * var j = 20;
 * var sum = i + j
 */
public class RuntimeForGlobalCodeTest extends TestCase {

    public void testIfRuntimeCanExecuteGlobalCode() {
        ECMARuntime runtime = new ECMARuntime();
        int result = runtime.execute(new GlobalCode());
        assertEquals(0, result);
    }


}
