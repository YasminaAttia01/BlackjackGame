/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Users;

import Game.Card;
import Game.InvalidCardRankExeception;
import Game.InvalidCardSuitException;
import Game.InvalidCardValueException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public final  class DealerHand extends Hand {
  private Card Hiddencard  ;
  
  
  public DealerHand (List<Card> theHand ){
     
      try {
          Hiddencard=new Card(theHand.get(0).getSuit1(),theHand.get(0).getValue(),theHand.get(0).getRank());
      } catch (InvalidCardValueException | InvalidCardSuitException | InvalidCardRankExeception ex) {
          Logger.getLogger(DealerHand.class.getName()).log(Level.SEVERE, null, ex);
      }
      for (Card theHand1 : theHand) {
          this.addCard(theHand1);
      }
      
     this.numberOfCards=theHand.size();
  }
    @Override
    public int calculateTotal() {
        	int total=0;
		boolean aceFlag = false;
      for (Card card : theHand) {
            
            int value= card.getValue();
            
            if ( value == 1) {
	      aceFlag = true;
        }
            total+= value;
      }
      if (aceFlag && total+9 <= 21) {
			total += 9;
		}
      
       return total;
    }
    
    /**
     *
     * @return
     */
    public int getnumberOfCards (){
    return this.numberOfCards;
    }

    /**
     *
     * @param card
     */
    @Override
    public void addCard(Card card) {
               if (theHand.size() < 12) {
            theHand.add(card);
           numberOfCards++;
        } else {
            System.out.println("Hand is full. Cannot add more cards.");
 }
    }
   
     public List<Card> getHand() {
        return theHand;
    }
    
  
     public void HandContent(boolean hiddenCardFlag){
         int Flag=0;
      if(hiddenCardFlag){
      System.out.println("HiddenCard {suit='', value=, rank=}");
          Flag++; 
      
      }
       for(int i=Flag;i<theHand.size();i++){
               System.out.println(theHand.get(i));
            }
        System.out.println("Card number=" +numberOfCards );
         if(!hiddenCardFlag){
      System.out.println("total="+this.calculateTotal());
      
      }

     }
      public Card  getHiddenCard(){
          return this.Hiddencard;
      }
      
      public void setHiddenCard(Card card){
      this.Hiddencard=card;
      }
      
      public void removeHiddenCard(){
      this.Hiddencard.setRank(" ");
      this.Hiddencard.setValue(0);
      this.Hiddencard.setSuit(' ');
      // this.theHand.remove(0);
      }
      
}

