package Game;

import Users.Dealer;
import Users.Player;
import java.util.Scanner;

public class BlackJack {
    private final Deck deck;
    private Dealer dealer;
    private Player player;
    private final GameHistory gameHistory;

    public BlackJack() {
        gameHistory = new GameHistory();
        System.out.println("Welcome to Blackjack!");
        System.out.println("");
        System.out.println("  BLACKJACK RULES: ");
        System.out.println("  -The player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
        System.out.println("  -Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
        System.out.println("  -The player cards are added up for their total.");
        System.out.println("  -Player “Hits” to gain another card from the deck. Players “Stay” to keep their current card total.");
        System.out.println("  -Dealer “Hits” until they equal or exceed 17.");
        System.out.println("  -The goal is to have a higher card total than the dealer without going over 21.");
        System.out.println("  -If the player total equals the dealer total, it is a “Push” and the hand ends.");
        System.out.println("");
        System.out.println("");

        // Using GameFactory to create deck, dealer, and player
        deck = GameFactory.createDeck();
        dealer = GameFactory.createDealer(deck);
        player = GameFactory.createPlayer(deck);

        // Display the initial hands
        dealer.DealerHandContent(true);
        player.PlayerHandContent();

        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Save initial state (memento)
        saveGameState();

        // Player's turn (Hit or Stand)
        do {
            System.out.print("Hit or stand? \n");
            userInput = scanner.nextLine();
            if ("Hit".equals(userInput)) {
                player.AddCardtoPlayerHand(deck.getCard(0));
                player.PlayerHandContent();
            }
        } while ("Hit".equals(userInput) && player.getPlayerHand().calculateTotal() <= 21);

        // Check if the player's total is greater than 21
        if (player.getPlayerHand().calculateTotal() > 21) {
            System.out.println("You went over 21. Dealer wins!");
            dealer.DealerHandContent(false);
        } else {
            // Dealer's turn
            dealer.DealerHandContent(false);

            // Dealer hits until reaching 17
            while (dealer.getDealerHand().calculateTotal() < 17) {
                dealer.AddCardtoDealerHand(deck.getCard(0));
            }

            // Display the final hands
            dealer.DealerHandContent(false);
            player.PlayerHandContent();

            // Determine the winner
            if (dealer.getDealerHand().calculateTotal() > 21 || player.compareTo(dealer)) {
                System.out.println("You win!");
            } else {
                System.out.println("Dealer wins!");
            }
        }

        // Option to undo (restore the previous game state)
        System.out.print("Do you want to undo the last action? (yes/no): ");
        userInput = scanner.nextLine();
        if ("yes".equalsIgnoreCase(userInput)) {
            restoreGameState();
        }
    }

    private void saveGameState() {
        // Create a snapshot of the current game state
        GameMemento memento = new GameMemento(player, dealer, "Initial State");
        gameHistory.saveState(memento);
        System.out.println("Game state saved.");
    }

    private void restoreGameState() {
        // Restore the last saved game state
        GameMemento memento = gameHistory.restoreState();
        if (memento != null) {
            this.player = memento.getPlayer();
            this.dealer = memento.getDealer();
            System.out.println("Game state restored.");
            dealer.DealerHandContent(true);
            player.PlayerHandContent();
        } else {
            System.out.println("No saved state to restore.");
        }
    }
}
