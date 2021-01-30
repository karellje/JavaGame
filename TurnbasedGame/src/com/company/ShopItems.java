package com.company;

public class ShopItems extends InventoryItem {

    public ShopItems(String name, double price, int min , int max) {
        super(name,price,min,max);
        super.name = name;
        super.price = price;
        super.min = min;
        super.max = max;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
