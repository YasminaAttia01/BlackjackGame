/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Deck extends Exception implements Serializable {
      
      List<Card> Deck = new ArrayList<>();
      
      
	public Deck(){
          String[] stringArray= {"Ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten","Jack","Queen","King"};
		try{
		for (int i = 0; i <13; i++) {
                    if(i<=9) {
                         Deck.add(new Card('H', i+1,stringArray[i]));
                         Deck.add(new Card('S', i+1,stringArray[i]));
                         Deck.add(new Card('D', i+1,stringArray[i]));
                         Deck.add(new Card('C', i+1,stringArray[i]));
                    } else {
                       
                         
                                Deck.add(new Card('H', 10,stringArray[i]));
                                Deck.add(new Card('S', 10,stringArray[i]));
                                Deck.add(new Card('D', 10,stringArray[i]));
                                Deck.add(new Card('C', 10,stringArray[i]));   
                    }
		}
		
		
		
		
	} catch (InvalidCardValueException | InvalidCardSuitException | InvalidCardRankExeception ex) {
              Logger.getLogger(Deck.class.getName()).log(Level.SEVERE, null, ex);
          }
      
}

      @Override
      public String toString(){

		String str = "";

		for (int i = 0; i < Deck.size(); i++) {
			str +=	Deck.get(i).toString() + " \n";
		}
		return str;
	}


      
	private void swapCards(int index1, int index2)  {	
		Card hold;
    hold = Deck.get(index1);
    Deck.set(index1, Deck.get(index2));
    Deck.set(index2, hold);
	}
        
    /**
     *
     */
    public void shuffle() {
		Random rn = new Random();
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < Deck.size(); j++) {
				swapCards(i, rn.nextInt(52));
			}
		}
		
	}
public Card getCard(int index) {
		Card card ;
               card= Deck.get(index);
		Deck.remove(index);
                Deck.add(card);
          return card;
                 
	}

 public List<Card> getHand(){
 List<Card> Hand = new ArrayList<>();
  for (int i=0;i< 2;i++){
  Hand.add(this.getCard(0));
  
  }
  return Hand;
 }
 
 public List<Card> getDeck(){
 
 return this.Deck;
 }
}





