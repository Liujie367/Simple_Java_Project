package com.pro3.domain;

/**
 * ClassName:PC
 * Package:com.pro3.domain
 * Date 2023/4/25 - 20:56
 * author:Jim367
 * Description:
 */

public class PC implements Equipment{
    private String model;//机器型号
    private String display;//显示器的名称


    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
