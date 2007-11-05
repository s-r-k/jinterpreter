package com.eclisp.operator;

import com.eclisp.preter.LispStatement;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: pair
 * Date: Apr 1, 2005
 * Time: 7:51:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class LesserThanOperator implements Operator {
    public Object operate(List<LispStatement> operands) {
        if (Integer.valueOf((String) operands.get(0).eval()).intValue() < Integer.valueOf((String) operands.get(1).eval()).intValue()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
