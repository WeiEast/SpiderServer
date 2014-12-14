package com.spiderserver.po;

/**
 * Created by apoptoxin on 2014/12/5.
 */
public class SchemaInfo {
    private int id;
    private String schemaname;
    private String strategy;

    public SchemaInfo() {
    }
    public SchemaInfo(String name, String strategy){
        this.schemaname = name;
        this.strategy = strategy;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchemaName() {
        return schemaname;
    }

    public void setSchemaName(String name) {
        this.schemaname = name;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
