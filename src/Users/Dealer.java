/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import Game.Card;
import java.util.List;

/**
 *
 * @author MSI
 */
public class Dealer  {
    
    private DealerHand DealerHand;
    
    public Dealer(List<Card> theHand){
        DealerHand=new DealerHand(theHand) ;
        
            }
    public void DealerHandContent(boolean hiddenCardFlag){
        
        if(!this.DealerHand.getHand().isEmpty()){
        System.out.println("Dealer Hand :");
         this.DealerHand.HandContent(hiddenCardFlag);
        }else {
            
        System.out.println("Dealer Hand is  Empty !");
        }        

     }
    public void AddCardtoDealerHand(Card card){
    
    this.DealerHand.addCard(card);
    }
    
    
    public void DeleteCard(int i){
    
    try {
          System.out.println( this.DealerHand.theHand.get(i) + " removed.");        
            this.DealerHand.theHand.remove(i);
           
            this.DealerHand.numberOfCards--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index. Cannot remove Card. " + e.getMessage());}
    }
    
      public void DeleleDealerHand(){
         
            this.DealerHand.theHand.clear();
         this.DealerHand.numberOfCards=0;
          this.DealerHand.removeHiddenCard();
         System.out.println("DealerHand removed"); 
          
    }
      public DealerHand getDealerHand(){
      
      return this.DealerHand;
              }
       public void setDealerHand(List<Card> newHand){
      
     
      for (Card card : newHand) {
            this.DealerHand.theHand.add(card);
            this.DealerHand.numberOfCards++;
           
        }
       this.DealerHand.setHiddenCard(newHand.get(0));
      
      }
     
      }
    
    


    

    


