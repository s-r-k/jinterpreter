package org.basic.interpreter;

public class DataType {
    public static final DataType INTEGER = new DataType("int");
    public static final DataType NUMBER = new DataType("number");


    private String keyword;

    public DataType(String keyword) {
        this.keyword = keyword;
    }
}
