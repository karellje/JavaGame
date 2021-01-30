package com.company;



public class Main {


    public static void main(String[] args) {
        Player player;
        String saveFile = "player.save";

        // loadObject() returnerar typen Object, så vi måste konvertera till Player
        // med en "type cast", alltså nya typen i parentes före värdet av gamla typen.
        if (FileUtils.loadObject(saveFile) != null) player = (Player) FileUtils.loadObject(saveFile);
        else {
            System.out.println("ditt namn: ");
            final String playerName = Utils.getUserInput();
            // Ingen användbar save hittas, instansiera ett nytt objekt
            player = new Human(playerName, 40);
        }
        System.out.println("Hej " + player.getName());

        new Game(player);
        if(!player.isDead()){
            FileUtils.saveObject(player, saveFile);
            System.out.println("thank you for playing! come again and we remember you");
        }else {
            System.out.println("thank you for playing!");
        }



    }
}


