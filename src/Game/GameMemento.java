package Game;

import Users.Dealer;
import Users.Player;

public class GameMemento {
    private final Player player;
    private final Dealer dealer;
    private final String gameState;

    public GameMemento(Player player, Dealer dealer, String gameState) {
        this.player = player;
        this.dealer = dealer;
        this.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public String getGameState() {
        return gameState;
    }
}
