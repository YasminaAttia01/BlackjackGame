package Game;

import Users.Dealer;
import Users.DealerHand;
import Users.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card card = null; 
          try {
            // TODO code application logic here
            card=new Card('D',1,"Ace");
           
        }catch (InvalidCardSuitException | InvalidCardValueException |InvalidCardRankExeception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
      
        /* Deck Deck=new Deck();
      
         Deck. shuffle();*/
         System.out.println(card.ShowCard());
        
      
        /* List<Card> theHand = new ArrayList<>();
         List<Card> theHand1 = new ArrayList<>();
       
         Card card2 = null; 
         Card card1=null;
           
      
        
       /* theHand.add(card);
         theHand.add(card1);
          theHand1.add(card2);
       
        
          
       // Player Player=new Player(Deck.getHand()); 
        // dealerhand.DeleteCard(3);
       // System.out.println(Deck);
         //dealerhand.AddCardtoDealerHand (card2);
     //  dealerhand.AddCardtoDealerHand (card1);
       //    Player.AddCardtoPlayerHand(card2);
    // Player.PlayerHandContent();
    // System.out.println(Deck.getHand());
     //System.out.println(Deck);
   // Dealer Dealer=new Dealer(Deck.getHand()); 
       //Player.DelelePlayerHand();
     // System.out.println(Player.getPlayerHand().calculateTotal());
     // dealerhand.setDealerHand(theHand1);
      //Dealer.DealerHandContent(false);
      //System.out.println(dealerhand.getDealerHand().getHiddenCard());
      // dealerhand.getDealerHand().removeHiddenCard();
     //  dealerhand.DealerHandContent(false);
        //dealerhand.DeleteCard(0);
         //dealerhand.DeleteCard(0);
     //   dealerhand.DeleteCard(1);
     // dealerhand.DeleteCard(0);
       
        
   
        //dealerhand.DealerHandContent(false);
       // System.out.println(dealerhand.getDealerHand().getHand().get(0));
       // dealerhand.DeleteCard(0);
        //dealerhand.getDealerHand().removeHiddenCard();
        //dealerhand.DealerHandContent(false);
        //dealerhand.getDealerHand().removeHiddenCard();
       //System.out.println(dealerhand.getDealerHand().getHiddenCard());
   /* Hand thehand=new Hand();
    thehand.addCard(card);
   thehand.addCard(card2);
   thehand.addCard(card3);
    System.out.println(thehand.getNumberOfCards());*/
    }
    
    
}
