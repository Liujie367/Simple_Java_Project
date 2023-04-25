package com.pro3.domain;

/**
 * ClassName:NoteBook
 * Package:com.pro3.domain
 * Date 2023/4/25 - 20:56
 * author:Jim367
 * Description:
 */

public class NoteBook implements Equipment{
    private String model;//机器的型号
    private double price;//机器的价格

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
