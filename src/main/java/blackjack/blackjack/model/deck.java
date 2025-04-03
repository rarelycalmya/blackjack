package blackjack.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    List<String> cards;

    public Deck() {
        String[] suits = {"H", "S", "D", "C"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

        cards = new ArrayList<>();
        for(String s: suits) {
            for(String r: ranks) {
                cards.add(r + s);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
