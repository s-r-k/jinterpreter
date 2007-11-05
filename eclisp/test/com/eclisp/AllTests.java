package com.eclisp;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.eclisp.operator.*;
import com.eclisp.preter.PreterTest;
import com.eclisp.parser.LispStatementBuilderTest;
import com.eclisp.parser.LispTokenBuilderTest;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 31, 2005
 * Time: 9:19:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PreterTest.class);

        suite.addTestSuite(DefineOperatorTest.class);
        suite.addTestSuite(EqualToOperatorTest.class);
        suite.addTestSuite(LesserThanOperatorTest.class);
        suite.addTestSuite(GreaterThanOperatorTest.class);
        suite.addTestSuite(ConditionalOperatorTest.class);
        suite.addTestSuite(AndOperatorTest.class);


		suite.addTestSuite(LispStatementBuilderTest.class);
		suite.addTestSuite(LispTokenBuilderTest.class);
        return suite;
    }
}
