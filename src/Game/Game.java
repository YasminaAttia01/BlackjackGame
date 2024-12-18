package Game;

import Game.Deck;

public class Game {
    private GameState state; // État actuel du jeu
    private Deck deck;       // Le deck de cartes utilisé pour la partie

    public Game() {
        this.deck = new Deck();  // Création du deck
        this.state = new PlayerTurn(); // Le jeu commence avec le tour du joueur
    }

    public void setState(GameState state) {
        this.state = state; // Change l'état du jeu
    }

    public void playGame() {
        System.out.println("Starting the game...");
        deck.shuffle(); // Mélange le deck
        System.out.println("Deck shuffled: " + deck);

        // Le jeu continue jusqu'à l'état "GameOver"
        while (!(state instanceof GameOver)) {
            state.handle(this); // Appelle le comportement de l'état actuel
        }

        System.out.println("Game has ended.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame(); // Lance la partie
    }
}
