package blackjackgame;

//import static Users.DataInsertion.insertData;
import static Users.DataInsertion.insertData;
import Users.User;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
//import static oracle.jdbc.driver.DatabaseError.test;

public class FXMLDocumentController {

    @FXML
    private Button Button;

    @FXML
    private TextArea TextArea;
    @FXML
    private Button Button1;
    private MediaPlayer mediaPlayer6;
    @FXML
    private Label YourName;
    @FXML
    private TextField Name;
    @FXML
    private TextField Name1;
    @FXML
    private Label YourName1;
    @FXML
   
   
    void handleButtonAction(ActionEvent event) throws ClassNotFoundException  {
            String test1 = Name1.getText();
            String test = Name.getText();
            
              User user = new User(test1, test);
              insertData(user.firstName(), user.lastName());
              System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
           
            
            
            Voice voice = VoiceManager.getInstance().getVoice("kevin16");
            Voice[] voicelist = VoiceManager.getInstance().getVoices();
            for(int i=0 ;i<voicelist.length;i++){
                System.out.println("#Voice: "+voicelist[i].getName());
            }
            if(voice!=null ){
                voice.allocate();
                System.out.println("Voice Rate: " +voice.getRate());
                System.out.println("Voice Pitch: " +voice.getPitch());
                System.out.println("Voice Volume: " +voice.getVolume());
                
                boolean status =voice.speak(" Welcome "+ test+" to Black Jack");
                System.out.println("Status: " +status);
                voice.deallocate();
            }else {
                System.out.println("Error on getting Voices");
            }
            String soundFile6 = "/cards/WelcomeSound.mp3";
            Media sound5 = new Media(getClass().getResource(soundFile6).toExternalForm());
            mediaPlayer6 = new MediaPlayer(sound5);
            Button.setVisible(false);
            
            // Show the text area with rules
            playSound6();
            YourName.setVisible(false);
            YourName1.setVisible(false);
            Name.setVisible(false);
            Name1.setVisible(false);
            TextArea.setEditable(false);
            TextArea.setVisible(true);
            Button1.setVisible(true);
           
        
    }

    @FXML
    private void handleButtonActionView(ActionEvent event ) throws IOException, ClassNotFoundException {
       
        
   Parent gameRoot = FXMLLoader.load(getClass().getResource("Card.fxml"));

        // Create a new scene
        Scene gameScene = new Scene(gameRoot);

        // Get the stage from the current event source
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene to the stage
        currentStage.setScene(gameScene);
        
    }
        private void playSound6() {
        mediaPlayer6.stop(); // Stop the sound in case it's already playing
        mediaPlayer6.play();
    }

}
