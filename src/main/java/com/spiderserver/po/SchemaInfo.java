package com.spiderserver.po;

import java.sql.Timestamp;

/**
 * Created by apoptoxin on 2014/12/5.
 */
public class SchemaInfo {
    private int id;
    private String schemaname;
    private String strategy;
    private String stor;
    private int stat;//0表示waiting，1表示running
    private Timestamp lastruntime;//上一次起调度的时间，与调度周期配合使用，若为空则表示新建配置还没有被调度过
    private long cycle;//调度周期

    public SchemaInfo() {
    }
    public SchemaInfo(String name, String strategy, String storage, long cycle, int status){
        this.schemaname = name;
        this.strategy = strategy;
        this.stor = storage;
        this.cycle = cycle;
        this.stat = status;
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

    public String getStor() {
        return stor;
    }

    public void setStor(String stor) {
        this.stor = stor;
    }

    public long getCycle() {
        return cycle;
    }

    public void setCycle(long cycle) {
        this.cycle = cycle;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int status) {
        this.stat = status;
    }

    public Timestamp getLastruntime() {
        return lastruntime;
    }

    public void setLastruntime(Timestamp lastruntime) {
        this.lastruntime = lastruntime;
    }
}
