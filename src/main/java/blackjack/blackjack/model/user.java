package blackjack.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected List<String> hand;
    protected int score;

    public User() {
        hand = new ArrayList<>();
        score = 0;
    }

    public void addCard(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore() {
        int tempScore = 0;
        int aceCount = 0;
        for (String card : hand) {
            char rank = card.charAt(0);
            if (rank == 'A') {
                aceCount++;
                tempScore += 11;
            } else if (rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') {
                tempScore += 10;
            } else {
                tempScore += Character.getNumericValue(rank);
            }
        }
        while (tempScore > 21 && aceCount > 0) {
            tempScore -= 10;
            aceCount--;
        }
        this.score = tempScore;
    }

    public abstract void play();
}
