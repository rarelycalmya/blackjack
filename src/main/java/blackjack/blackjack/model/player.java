package blackjack.blackjack.model;

import java.util.Scanner;


public class Player extends User {

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Your hand: " + hand + " | Score: " + score);
            System.out.print("Do you want to (H)it or (S)tand? ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("H")) {
                System.out.println("You chose to hit!");
                break;
            } else if (action.equals("S")) {
                System.out.println("You chose to stand!");
                break;
            } else {
                System.out.println("Invalid input. Please enter H or S.");
            }
        }
    }
}
