package com.pro3.domain;

/**
 * ClassName:Printer
 * Package:com.pro3.domain
 * Date 2023/4/25 - 20:57
 * author:Jim367
 * Description:
 */

public class Printer implements Equipment{
    private String name;//机器的名称
    private String type;//机器的类型

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
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

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
