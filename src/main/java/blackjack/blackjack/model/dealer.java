package blackjack.blackjack.model;

public class Dealer extends User {

    @Override
    public void play() {
        while (score < 17) {
            System.out.println("Dealer hits...");
            // Actual hit logic will be in GameService
        }
        System.out.println("Dealer stands with hand: " + hand + " | Score: " + score);
    }
}
