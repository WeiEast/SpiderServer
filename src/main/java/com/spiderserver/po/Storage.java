package com.spiderserver.po;

/**
 * Created by apoptoxin on 2014/12/15.
 */
public class Storage {
    private int id;
    private String name;//名称
    private String type;//值类型
    private int input;//输入源
    private String mode;//解析方式：str；regex；xpath
    private String source;//解析路径

    public Storage() {
    }

    public Storage(int id, String name, String type, int input, String mode, String source) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.input = input;
        this.mode = mode;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
