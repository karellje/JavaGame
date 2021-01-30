package com.company;

import java.util.ArrayList;

public class Shop {

    ArrayList<ShopItems> items = new ArrayList<>();

    public Shop(){
        items.add(new ShopItems("Scimitar", 40,30,40));
        items.add(new ShopItems("2h Sword", 50,25,60));
    }

    public ArrayList<ShopItems> getItems() {
        return items;
    }

}
