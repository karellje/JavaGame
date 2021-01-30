package com.company;

public class Enemy extends Player {

    public Enemy(String name, double money) {
        super(name,money);
    }
    //kör över functionen den inherits från Player.
    @Override
    public void winning() {
        System.out.println("ENEMY WON");
    }

}
