package com.company;



public class Game {
    public Game(Player player){
        Shop shop = new Shop();
        String choice;
        String weaponAction;
        String shopAction;
        label:
        while (!player.isDead()) {

            Player AI = new Enemy("AI",100);

            System.out.println("Fight (1) shop(2) quit(3)");
            choice = Utils.getUserInput();
            int nummer = 0;
            switch (choice) {
                case "1":
                    while (!player.isDead() && !AI.isDead()) {
                        nummer++;
                        System.out.println(player.getName() + " har " + player.getHealth() + " HP");

                        System.out.println(AI.getName() + " har " + AI.getHealth() + " HP");


                        InventoryItem currentThing;
                        System.out.println("--- Välj vapen: ");
                        for (int i = 0; i < player.inventory.getWeapons().size(); i++) {

                            currentThing = player.inventory.getWeapons().get(i);
                            System.out.format("[%d] - %s\n",
                                    i + 1,
                                    currentThing.getName());
                        }

                        System.out.println("round: " + nummer);

                        String weapon;
                        String aiweapon;

                        weaponAction = Utils.getUserInput();
                        if (weaponAction.matches("\\d+")) {

                            // Skapa ett riktigt heltal av shopAction, minska med ett för array-index
                            int itemIdx = Integer.parseInt(weaponAction) - 1;

                            // Är index inom ramarna för ArrayList?
                            if (itemIdx < player.inventory.getWeapons().size()) {

                                // Använd get() för att hämta rätt sak ur ArrayListen
                                // åkalla player.buyThing() för att köpa den

                                player.chooseThing(player.inventory.getWeapons().get(itemIdx));
                                aiweapon = AI.inventory.getWeapons().get(0).getName();
                                weapon = player.inventory.getWeapons().get(itemIdx).getName();

                                System.out.println(AI.getName() + " gav " + AI.attackThing(player, AI.inventory.getWeapons().get(0)) + " skada med vapnet " + aiweapon);
                                System.out.println(player.getName() + " gav " + player.attackThing(AI, player.inventory.getWeapons().get(itemIdx)) + " skada med vapnet " + weapon + "\n");

                            } else {
                                System.out.println("Ogiltigt produktnummer för ArrayList!\n");
                            }
                            if (player.isDead() && AI.isDead()) {
                                System.out.println("Both died, try again");

                            } else if (AI.isDead()) {
                                Loot loot = new Loot();
                                loot.Chest(player);
                                System.out.println(AI.getName() + " is dead!");
                                player.winning();
                                break;
                            } else if (player.isDead()) {
                                System.out.println(player.getName() + " is dead!");
                                AI.winning();
                                break;
                            }

                        }
                    }
                    break;
                case "2":
                    while (true) {

                        // Visa senaste inköp och pengar kvar.
                        if (player.getLatestPurchase() != null) {
                            System.out.format("----------\nDitt senaste inköp var %s, du har %.2f €\n",
                                    player.getLatestPurchase().getName(),
                                    player.getMoney());
                        }

                        // container-objekt för att snygga till looparna
                        ShopItems currentThing;
                        // 1. ArrayList-loop
                        System.out.println("Till salu: ");
                        for (int i = 0; i < shop.getItems().size(); i++) {

                            currentThing = shop.getItems().get(i);
                            System.out.println(i + 1 + " " + currentThing.getName() + ", priset: " + currentThing.getPrice() + " min damage: " + currentThing.getMin() + " max damage: " + currentThing.getMax());
                        }
                        // Skriv ut menyn
                        System.out.format("Köp från ArrayList, välj [1-%d] eller [q] för att lämna butiken\n",
                                shop.getItems().size());


                        // Läs användarens input, String.trim() tar bort onödig whitespace
                        shopAction = Utils.getUserInput();

                        // shopAction är ett heltal, vi köper från Arraylist
                        if (shopAction.matches("\\d+")) {

                            // Skapa ett riktigt heltal av shopAction, minska med ett för array-index
                            int itemIdx = Integer.parseInt(shopAction) - 1;

                            // Är index inom ramarna för ArrayList?
                            if (itemIdx < shop.getItems().size()) {

                                // Använd get() för att hämta rätt sak ur ArrayListen
                                // åkalla player.buyThing() för att köpa den
                                player.buyThing(player, shop.getItems().get(itemIdx));

                            } else {
                                System.out.println("Ogiltigt produktnummer för ArrayList!\n");
                            }

                            // shopAction är "q och alla andra bokstäver" - lämna butiken
                        } else {
                            System.out.println("Hej då!");
                            break;
                        }


                    }
                    break;
                case "3":
                    break label;
                default:
                    System.out.println("try again");
                    continue;
            }
        }

    }
}
