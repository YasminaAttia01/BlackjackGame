/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Game.Card;
import Game.MyComparator;
import java.util.List;

/**
 *
 * @author MSI
 */
public class Player implements MyComparator<Dealer> {
    private final  PlayerHand PlayerHand;
    
     public Player(List<Card> theHand){
        PlayerHand=new PlayerHand(theHand);
        
            }

    /**
     *
     *
     */
    public void PlayerHandContent(){
        
        if(!this.PlayerHand.getHand().isEmpty()){
        System.out.println("Player Hand :");
         this.PlayerHand.HandContent();
         
        }else {
            
        System.out.println("Player Hand is  Empty !");
        }        

     }
      public void AddCardtoPlayerHand(Card card){
    
    this.PlayerHand.addCard(card);
    }
      
          public void DeleteCard(int i){
    
    try {
          System.out.println( this.PlayerHand.theHand.get(i) + " removed.");        
            this.PlayerHand.theHand.remove(i);
           
            this.PlayerHand.numberOfCards--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. Cannot remove Card. " + e.getMessage());}
    }
    
        public void DelelePlayerHand(){
         
            this.PlayerHand.theHand.clear();
         this.PlayerHand.numberOfCards=0;
         System.out.println("PlayerHand removed"); 
          
    }  
         public PlayerHand getPlayerHand(){
      
      return this.PlayerHand;
              }
         
       public void setPlayerHand(List<Card> newHand){
      
     
      for (Card card : newHand) {
            this.PlayerHand.theHand.add(card);
            this.PlayerHand.numberOfCards++;
           
        }
       
      
      }

    @Override
    public boolean compareTo(Dealer o) {
        return this.PlayerHand.calculateTotal()> o.getDealerHand().calculateTotal();
        
           }
}
