package com.spiderserver.po;

import java.sql.Timestamp;

/**
 * Created by apoptoxin on 2014/12/5.
 */
public class SchemaInfo {
    private int id;
    private String schemaname;
    private String strategy;
    private String storage;
    private int status;//0表示waiting，1表示running
    private Timestamp lastruntime;//上一次起调度的时间，与调度周期配合使用，若为空则表示新建配置还没有被调度过
    private long cycle;//调度周期

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

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public long getCycle() {
        return cycle;
    }

    public void setCycle(long cycle) {
        this.cycle = cycle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getLastruntime() {
        return lastruntime;
    }

    public void setLastruntime(Timestamp lastruntime) {
        this.lastruntime = lastruntime;
    }
}
