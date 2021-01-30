package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static Integer randomizer(int min, int max){
        int random = ThreadLocalRandom.current().nextInt(min, max +1);
        return random;
    }
}
