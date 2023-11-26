/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Users.Dealer;
import Users.Player;
import java.util.Scanner;
/**
 *
 * @author MSI
 */
public class BlackJack {
    private final Deck deck;
    private final Dealer dealer;
    private final Player player;
    
    /**
     *
     */
    public  BlackJack(){
    
    System.out.println("Welcome to Blackjack!");
		System.out.println("");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println("	-The player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("	-The player cards are added up for their total.");
		System.out.println("	-Player “Hits” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
		System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends."); 
		System.out.println("");
		System.out.println("");
    deck =new Deck();
    deck.shuffle();
    dealer=new Dealer(deck.getHand());
    player = new Player(deck.getHand());
    dealer.DealerHandContent(true);
    player.PlayerHandContent();
     Scanner scanner = new Scanner(System.in);
      String userInput;
    // Inside the do-while loop
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


    
   
    
      
    
    
}}
    
    
}
