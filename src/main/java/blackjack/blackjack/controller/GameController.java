package blackjack.blackjack.controller;

import blackjack.blackjack.model.Player;
import blackjack.blackjack.model.Dealer;
import blackjack.blackjack.service.GameService;

public class GameController {
    private GameService gameService;

    public GameController() {
        gameService = new GameService();
    }

    public void startGame() {
        gameService.startGame();
    }

    public Player getPlayer() {
        return gameService.getPlayer();
    }

    public Dealer getDealer() {
        return gameService.getDealer();
    }

    public String getWinnerMessage() {
        return gameService.getWinnerMessage();
    }
}
