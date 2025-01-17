/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Game.Card;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author MSI
 */
public final class PlayerHand extends Hand{

   
      public PlayerHand (List<Card> theHand ){
    for (Card card : theHand) {
          this.addCard(card);
      }
     this.numberOfCards=theHand.size();}
    @Override
        public void addCard(Card card) {
               if (theHand.size() < 12) {
            theHand.add(card);
           numberOfCards++;
        } else {
            System.out.println("Hand is full. Cannot add more cards.");
 }
    }

    @Override
public int calculateTotal() {
    AtomicBoolean aceFlag = new AtomicBoolean(false);

    int total = theHand.stream()
            .mapToInt(Card::getValue)
            .peek((int value) -> {
                if (value == 1) {
                    aceFlag.set(true);
                }
            })
            .sum();

    if (aceFlag.get() && total + 9 <= 21) {
        total += 9;
    }

    return total;
}

       
       
       
         public int getnumberOfCards (){
    return this.numberOfCards;
    }
       public List<Card> getHand() {
        return theHand;
    }
       
            public void HandContent(){
         
   for(int i=0;i<theHand.size();i++){
               System.out.println(theHand.get(i));
            }
        System.out.println("Card number=" +numberOfCards );
        System.out.println("total="+this.calculateTotal());
     }

  
}
