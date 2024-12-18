package Game;

public class GameOver implements GameState {
    @Override
    public void handle(Game game) {
        System.out.println("Game Over: Calculating results...");
        // Logique pour afficher les résultats et terminer la partie
    }
}