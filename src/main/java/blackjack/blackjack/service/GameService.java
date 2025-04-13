package blackjack.blackjack.service;

import blackjack.blackjack.model.Deck;
import blackjack.blackjack.model.Player;
import blackjack.blackjack.model.Dealer;

public class GameService {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private String winnerMessage = "";

    public GameService() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
    }

    public void startGame() {
        deck.shuffle();

        // Deal 2 cards to player and dealer
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        player.setScore();
        dealer.setScore();

        System.out.println("\nGame Start!");
        System.out.println("Player's hand: " + player.getHand() + " | Score: " + player.getScore());
        System.out.println("Dealer's hand: [" + dealer.getHand().get(0) + ", ?]");

        // Player turn
        player.play();
        player.setScore();

        if (player.getScore() > 21) {
            winnerMessage = "Player busted! Dealer wins.";
            System.out.println(winnerMessage);
            return;
        }

        // Dealer turn
        System.out.println("\nDealer reveals their hand: " + dealer.getHand());
        dealer.play();
        dealer.setScore();

        determineWinner();
    }

    private void determineWinner() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        winnerMessage = "\nFinal Scores:\n";
        winnerMessage += "Player: " + playerScore + "\n";
        winnerMessage += "Dealer: " + dealerScore + "\n";

        if (dealerScore > 21 || playerScore > dealerScore) {
            winnerMessage += "Player wins!";
        } else if (playerScore == dealerScore) {
            winnerMessage += "It's a tie!";
        } else {
            winnerMessage += "Dealer wins!";
        }

        System.out.println(winnerMessage);
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }
}
