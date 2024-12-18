package Game;

import Users.Dealer;
import Users.Player;

public class GameFactory {

    public static Deck createDeck() {
        Deck deck = new Deck();
        deck.shuffle();
        return deck;
    }

    public static Dealer createDealer(Deck deck) {
        return new Dealer(deck.getHand());
    }

    public static Player createPlayer(Deck deck) {
        return new Player(deck.getHand());
    }
}
