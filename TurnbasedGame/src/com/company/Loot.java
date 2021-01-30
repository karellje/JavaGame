package com.company;

public class Loot {
        int Min;
        int Max;
    public void Chest(Player looter){
        Min = 0;
        Max = 25;
        int luck = Utils.randomizer(Min,Max);
        if (luck == 10) {
            looter.inventory.setWeapons(new ShopItems("Legendary GodSword", 10, 90, 100));
            System.out.println("You got the Legendary GodSword");

        }else if (luck >= 11 && luck <= 20){
            Min = 10;
            Max = 100;
            double lootMoney = Utils.randomizer(Min,Max);
            looter.setMoney(looter.getMoney()+lootMoney);
            System.out.println("you got: "+ lootMoney + "€ from the enemy");

        }else if (luck >= 0 && luck <= 9){
            Min = 20;
            Max = 40;
            int lootHealth = Utils.randomizer(Min,Max);
            looter.setHealth(looter.getHealth()+lootHealth);
            System.out.println("you got: "+ lootHealth + "HP from the enemy");
        }
        else {
            System.out.println("you got Nothing");
        }
    }
}
