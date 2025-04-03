package blackjack.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    List<String> hand;
    int score;

    public User() {
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void addcard(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public abstract void play();
}
