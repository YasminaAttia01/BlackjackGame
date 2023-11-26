package Game;


import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class Card implements MyComparator<Card> {
    private char suit;
    private int value;
    private String rank;
   
    
 public Card( char suit, int value,String rank ) throws InvalidCardValueException, InvalidCardSuitException,InvalidCardRankExeception {
		String[] stringArray = {"Ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten","Jack","Queen","King"};
                List<String> stringList = Arrays.asList(stringArray);
     
                if (value < 1 || value > 10) {
			throw new InvalidCardValueException(value);
		} else {
			
			this.value = value;
		}
		if (suit!='H'&& suit!='S'&& suit!='D' &&  suit!='C') {
			
                        throw new InvalidCardSuitException(suit);
		} else {
			
                        this.suit = suit;
		}
                if (stringList.contains(rank)) {
                   
                     this.rank=rank;
                      
                     
                   
                }
                
                  else {
                    
                     throw new InvalidCardRankExeception(rank);
                    
                }
		
		}
    
    public String getSuit(){
        String Suit;
        Suit = switch (this.suit) {
            case 'H' -> "Hearts";
            case 'S' -> "Spades";
            case 'C' -> "Clubs";
            case 'D' -> "Diamonds";
            default -> "Unknown";
        };
		
		return Suit;
    }
    
     public int  getValue(){
     return value;
    }
     
     public String getRank(){
      return rank;
     }
      public char getSuit1(){
      return suit;
     }
    public void setSuit(char suit) {
        this.suit = suit;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setRank( String rank) {
        this.rank = rank; 
    }
       @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                ", rank=" + rank +
                '}';
    }
    @Override
    public boolean compareTo    (Card other) {
        return this.value > other.value;
    }
public String ShowCard(){
String CardValue= String.valueOf(this.getValue());

return "cards/"+ CardValue+"-"+this.getSuit1()+"-"+this.getRank()+".png";
}
    
    
}



