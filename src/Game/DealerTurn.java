package Game;

public class DealerTurn implements GameState {
    @Override
    public void handle(Game game) {
        System.out.println("Dealer's turn: Dealer is playing...");
        // Logique pour le tour du dealer
        game.setState(new GameOver()); // Passe à la fin du jeu
    }
}
