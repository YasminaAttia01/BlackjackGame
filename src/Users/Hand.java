package Users;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Game.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MSI
 */
 abstract class Hand implements Serializable {
      List<Card> theHand = new ArrayList<>();
      int numberOfCards = 0;
      
      public abstract int calculateTotal() ;
      public abstract void addCard(Card card) ;


}

