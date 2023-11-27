/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package blackjackgame;

import Game.Deck;
import Users.Dealer;
import Users.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * FXML Controller class
 *
 * @author MSI
 */
public class CardController implements Initializable {

    @FXML
    private Button hit;
    @FXML
    private Button stand;
    @FXML
    private ImageView Card1;
    @FXML
    private ImageView Card2;
    @FXML
    private ImageView Card3;
    @FXML
    private ImageView Card4;
     
    /**
     * Initializes the controller class.
     * @param url
     */
      // Declare an array of ImageView
  
    private ImageView[] cardImages;
    private ImageView[] DealersCard;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    @FXML
    private TextField TotalCards;
    @FXML
    private TextField BlackJackRule;
    @FXML
    private ImageView HiddenCard;
    @FXML
    private ImageView DealerCard2;
    @FXML
    private ImageView DealerCard3;
    @FXML
    private ImageView DealerCard4;
    @FXML
    private TextField TotalCards2;
    @FXML
    private ImageView Card5;
    @FXML
    private ImageView Card6;
    @FXML
    private ImageView Card7;
    @FXML
    private ImageView DealerCard5;
    @FXML
    private ImageView DealerCard6;
    @FXML
    private ImageView DealerCard7;
   private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
     private MediaPlayer mediaPlayer3;
     private MediaPlayer mediaPlayer4;
     private MediaPlayer mediaPlayer5;
    @FXML
    private Button ResetButton;
    @FXML
    private TextField test;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ResetButton.setVisible(false);
      
   deck =new Deck();
    deck.shuffle();
    dealer =new Dealer(deck.getHand());
    player =new Player(deck.getHand());
     cardImages = new ImageView[]{Card1, Card2, Card3, Card4,Card5,Card6,Card7};
     DealersCard = new ImageView[]{HiddenCard, DealerCard2, DealerCard3, DealerCard4,DealerCard5,DealerCard6,DealerCard7};
     Image image1=new Image("cards/BACK.png");
     Image image2=new Image(dealer.getDealerHand().getHand().get(1).ShowCard());
     DealersCard[0].setImage(image1);
     DealersCard[1].setImage(image2);
   for (int i=0;i<player.getPlayerHand().getnumberOfCards();i++){
    Image image = new Image(player.getPlayerHand().getHand().get(i).ShowCard());
    
            System.out.println(player.getPlayerHand().getHand().get(i).ShowCard());
     cardImages[i].setImage(image);
    }
 updateTotalCards();
    TotalCards2.setText("DEALER'S TOTAL:"+String.valueOf(dealer.getDealerHand().getHand().get(1).getValue()));
    
 String soundFile = "/cards/CardSound.mp3";
    Media sound = new Media(getClass().getResource(soundFile).toExternalForm());
    mediaPlayer = new MediaPlayer(sound);
    
    String soundFile1 = "/cards/DealerWins.mp3";
    Media sound1 = new Media(getClass().getResource(soundFile1).toExternalForm());
    mediaPlayer2 = new MediaPlayer(sound1);
    
    String soundFile2 = "/cards/WinSound.mp3";
    Media sound2 = new Media(getClass().getResource(soundFile2).toExternalForm());
    mediaPlayer3 = new MediaPlayer(sound2);
    
    String soundFile3 = "/cards/BlackJack.mp3";
    Media sound3 = new Media(getClass().getResource(soundFile3).toExternalForm());
    mediaPlayer4 = new MediaPlayer(sound3);
    
    
    String soundFile5 = "/cards/YouWin.mp3";
    Media sound4 = new Media(getClass().getResource(soundFile5).toExternalForm());
    mediaPlayer5 = new MediaPlayer(sound4);
    }    

    @FXML
    private void HitCard(ActionEvent event) {
      
         player.AddCardtoPlayerHand(deck.getCard(0));
          Image image = new Image(player.getPlayerHand().getHand().get(player.getPlayerHand().getnumberOfCards()-1).ShowCard());
          cardImages[player.getPlayerHand().getnumberOfCards()-1].setImage(image);
          playSound();
   
        updateTotalCards();
     if (player.getPlayerHand().calculateTotal() >= 21) {
          hit.setVisible(false);
        stand.setVisible(false);
       
        ResetButton.setVisible(true);
    
     
       if (player.getPlayerHand().calculateTotal()==21){
              playSound4();
               BlackJackRule.setText("    You have a BlackJack");
              
            }else {
              playSound2();
        BlackJackRule.setText("You went over 21. Dealer wins!");
     
     }
     
       
     
      
    
            }
    }
    

    @FXML
    private void StandCard(ActionEvent event) {
        Image image1=new Image(dealer.getDealerHand().getHand().get(0).ShowCard());
        DealersCard[0].setImage(image1);
        TotalCards2.setText("DEALER'S TOTAL:"+String.valueOf(dealer.getDealerHand().calculateTotal()));
         while (dealer.getDealerHand().calculateTotal() < 17) {
        dealer.AddCardtoDealerHand(deck.getCard(0));
         TotalCards2.setText("DEALER'S TOTAL:"+String.valueOf(dealer.getDealerHand().calculateTotal()));
         Image image=new Image(dealer.getDealerHand().getHand().get(dealer.getDealerHand().getnumberOfCards()-1).ShowCard());
         DealersCard[dealer.getDealerHand().getnumberOfCards()-1].setImage(image);
         
        
    }    hit.setVisible(false);
        stand.setVisible(false);
        ResetButton.setVisible(true);
       if (dealer.getDealerHand().calculateTotal() > 21 || player.compareTo(dealer)) {
        playSound5();
        playSound3();
        
        
        BlackJackRule.setText("        You win!");
    } else if (player.getPlayerHand().calculateTotal()==dealer.getDealerHand().calculateTotal()){
        
         
        BlackJackRule.setText("    Push");
    }else {
    
         playSound2();
        BlackJackRule.setText("       Dealer wins!");
    }
    }
      private void updateTotalCards() {
        // Set the text of TotalCards to the total number of cards in the player's hand
       test.setText("YOUR TOTAL:"+String.valueOf(player.getPlayerHand().calculateTotal()));
       
    }
         private void playSound() {
        mediaPlayer.stop(); // Stop the sound in case it's already playing
        mediaPlayer.play();
    }
            private void playSound2() {
        mediaPlayer2.stop(); // Stop the sound in case it's already playing
        mediaPlayer2.play();
    }
                  private void playSound3() {
        mediaPlayer3.stop(); // Stop the sound in case it's already playing
        mediaPlayer3.play();
    }
                  
      private void playSound4() {
        mediaPlayer4.stop(); // Stop the sound in case it's already playing
        mediaPlayer4.play();
    }
      
        private void playSound5() {
        mediaPlayer5.stop(); // Stop the sound in case it's already playing
        mediaPlayer5.play();
    }
            
  
    @FXML
    private void resetGame(ActionEvent event) {
    // Clear player and dealer hands
    
    updateCardImages();
      player.DelelePlayerHand();
      dealer.DeleleDealerHand();
    

    // Shuffle the deck and deal initial cards
    deck.shuffle();
    dealer.AddCardtoDealerHand(deck.getCard(0));
    dealer.AddCardtoDealerHand(deck.getCard(0));
    player.AddCardtoPlayerHand(deck.getCard(0));
    player.AddCardtoPlayerHand(deck.getCard(0));
     Image image1=new Image("cards/BACK.png");
     Image image2=new Image(dealer.getDealerHand().getHand().get(1).ShowCard());
     DealersCard[0].setImage(image1);
     DealersCard[1].setImage(image2);
    // Update the images and total cards display
     for (int i=0;i<player.getPlayerHand().getnumberOfCards();i++){
    Image image = new Image(player.getPlayerHand().getHand().get(i).ShowCard());
     cardImages[i].setImage(image);
    }
    updateTotalCards();
    TotalCards2.setText("DEALER'S TOTAL:" + String.valueOf(dealer.getDealerHand().getHand().get(1).getValue()));
    BlackJackRule.setText(""); // Clear the result message
        hit.setVisible(true);
        stand.setVisible(true);
         ResetButton.setVisible(false);
    // Stop any playing sounds
    mediaPlayer.stop();
    mediaPlayer2.stop();
    mediaPlayer4.stop();
    setEditableForTextInputComponents(false);
}
    private void updateCardImages() {
    // Set initial images for player's hand
    for (int i = 0; i < player.getPlayerHand().getnumberOfCards(); i++) {
        cardImages[i].setImage(null);
        
  for (int j = 0; j < dealer.getDealerHand().getnumberOfCards(); j++) {
        DealersCard[j].setImage(null);
    }
    }
    }
    
      private void setEditableForTextInputComponents(boolean editable) {
       setEditableForNode( test, editable);
        setEditableForNode(TotalCards2, editable);
       
        setEditableForNode(BlackJackRule, editable);}
        private void setEditableForNode(Node node, boolean editable) {
        if (node instanceof TextField) {
            ((TextField) node).setEditable(editable);
        } else if (node instanceof TextArea) {
            ((TextArea) node).setEditable(editable);
        }
    
}}
