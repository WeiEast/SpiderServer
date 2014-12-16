package com.spiderserver.po;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apoptoxin on 2014/11/27.
 */
public class Schema {
    private int id;
    private int way;/*1表示抓取，2表示取值*/
    private List<Schema> next;
    private String mode;//解析方式
    private String source;//解析路径

    //构造函数
    public Schema(){

    }

    public Schema(int id,int way,String mode,String source){
        this.id = id;
        this.way = way;
        this.mode = mode;
        this.source = source;
        next = new ArrayList<Schema>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Schema> getNext() {

        return next;
    }

    public void setNext(List<Schema> next) {
        this.next = next;
    }

    public int getWay() {

        return way;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
