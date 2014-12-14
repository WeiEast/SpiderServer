package com.spiderserver.po;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apoptoxin on 2014/12/4.
 */
public class Table {
    private String tableName;
    private Map<String,String> col;//列名为key，value为列的属性
    private String key;//主键，联合主键的话用逗号分隔，构造一个字符串

    public Table(){
        tableName = "";
        col = new HashMap<String, String>();
        key = "";
    }
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, String> getCol() {
        return col;
    }

    public void setCol(Map<String, String> col) {
        this.col = col;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
