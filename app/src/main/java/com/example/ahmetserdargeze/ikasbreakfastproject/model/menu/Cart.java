package com.example.ahmetserdargeze.ikasbreakfastproject.model.menu;

/**
 * Created by ahmetserdargeze on 29.06.2018.
 */

public class Cart {
    private int id;
    private int quantity;
    private double sell_price;
    private double differ_tax;
    private String name;
    private double total_price;



    public Cart(int id, int quantity, double sell_price, double differ_tax, String name, double total_price) {
        this.id = id;
        this.quantity = quantity;
        this.sell_price = sell_price;
        this.differ_tax = differ_tax;
        this.name = name;
        this.total_price = total_price;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public double getDiffer_tax() {
        return differ_tax;
    }

    public void setDiffer_tax(double differ_tax) {
        this.differ_tax = differ_tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
