package org.basic.interpreter;

public class DataType {
    public static final DataType INTEGER = new DataType("int");
    private String keyword;

    public DataType(String keyword) {
        this.keyword = keyword;
    }
}
