package com.eclisp.operator;

import com.eclisp.preter.LispStatement;
import com.eclisp.preter.Environment;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Mar 31, 2005
 * Time: 8:36:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomOperator implements Operator {
    private List formalParams;
    private LispStatement body;

    public CustomOperator(List param, LispStatement body) {
        this.formalParams = param;
        this.body = body;
    }

    public Object operate(List<LispStatement> actualParams) {
        setUpEnv(actualParams);
        Object result = body.eval();
        cleanUpEnv();
        return result;
    }

    private void setUpEnv(List<LispStatement> actualParams) {
        Iterator<LispStatement> actualParamsiterator = actualParams.iterator();
        Iterator formalParamsIterator = formalParams.iterator();
        while (actualParamsiterator.hasNext() && formalParamsIterator.hasNext()) {
			String formalParam = formalParamsIterator.next().toString();
            Environment.setenv(formalParam, actualParamsiterator.next().eval());
        }
    }

    private void cleanUpEnv() {
        for (Iterator iterator = formalParams.iterator(); iterator.hasNext();) {
            Environment.unsetenv(iterator.next().toString());
        }
    }
}
