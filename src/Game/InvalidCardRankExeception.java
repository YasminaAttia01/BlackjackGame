package Game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class InvalidCardRankExeception extends Exception  
{
     private String rankIdentifier = "?";
    
	public InvalidCardRankExeception (String invalidRank) {

		rankIdentifier = invalidRank;

		System.out.println("Invalid rank" + " " + invalidRank);
	}
       
	
    @Override
	public String toString(){

		return ("Attempted to create card with invalid Rank argument" + " " + this.rankIdentifier);

	}
	
	public String getSuitDesignator() {
		
		return rankIdentifier;
	}
        
    
}
