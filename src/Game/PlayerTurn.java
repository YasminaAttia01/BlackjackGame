package Game;

public class PlayerTurn implements GameState {
    @Override
    public void handle(Game game) {
        System.out.println("Player's turn: Player is playing...");
        // Logique pour le tour du joueur (ex: piocher des cartes)
        game.setState(new DealerTurn()); // Passe au tour du dealer
    }
}

