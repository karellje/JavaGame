package com.company;
import java.io.Serializable;

public abstract class Player implements Serializable,Actions {

    private final String name;
    private double money;//attribut
    ShopItems latestPurchase;

    private int health = 100;


    public Player(String name, double money) {  //konstruktor
        this.name = name;
        this.money = money;
    }

    public String getName(){
        return name;
    }


    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    Inventory inventory = new Inventory();


    public int attackThing(Player defender, InventoryItem vapen ) {
        int max = vapen.getMax();
        int min = vapen.getMin();
        int attack = Utils.randomizer(min,max);
        int nuvarande = defender.getHealth();
        defender.setHealth(nuvarande - attack);

        return attack;
    }

    public void buyThing(Player buyer, ShopItems thing) {
        // Har vi råd med saken? Ingen kredit i den här butiken!
        if (thing.getPrice() <= money) {
            money = money - thing.getPrice();
            latestPurchase = thing;
            buyer.inventory.setWeapons(thing);

        } else {
            System.out.format("Du har inte råd med %s!\n", thing.getName());
        }
    }
    public ShopItems getLatestPurchase() {
        return latestPurchase;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money){
        this.money = money;
    }

    public void chooseThing(InventoryItem inventory) {
        // Har vi råd med saken? Ingen kredit i den här butiken!
    }



    public boolean isDead(){
        return (health <=0);
    }
    //lagar färdigt human wins så man endast behöver Override i Enemy
    public void winning(){
        System.out.println("human vann");
    }


}