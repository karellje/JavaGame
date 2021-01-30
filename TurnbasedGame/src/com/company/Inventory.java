package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {

    public ArrayList<InventoryItem> weapons = new ArrayList<>();

    public Inventory(){
        weapons.add(new Weapons("Dagger", 10, 10, 20));
        weapons.add(new Weapons("Maple bow", 10, 15, 30));

    }

    public ArrayList<InventoryItem> getWeapons(){
        return weapons;
    }

    public void setWeapons(ShopItems weapon){
        weapons.add(weapon);
    }


}

