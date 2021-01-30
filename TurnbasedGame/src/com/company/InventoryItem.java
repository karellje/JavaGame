package com.company;

import java.io.Serializable;

abstract class InventoryItem implements Serializable {
    public String name;
    public  int min;
    public int max;
    public double price;

    InventoryItem(String name, double price, int min, int max) {
        this.name = name;
        this.price = price;
        this.min = min;
        this.max = max;
    }

    public String getName(){
        return name;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public double getPrice() {
        return price;
    }
}