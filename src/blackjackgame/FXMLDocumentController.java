package blackjackgame;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    private Button Button;

    @FXML
    private TextArea TextArea;
    @FXML
    private Button Button1;
   
    @FXML
    void handleButtonAction(ActionEvent event) {
    Button.setVisible(false);

        // Show the text area with rules
        TextArea.setVisible(true);
        Button1.setVisible(true);
        
    }

    @FXML
    private void handleButtonActionView(ActionEvent event ) throws IOException {
        
   Parent gameRoot = FXMLLoader.load(getClass().getResource("Card.fxml"));

        // Create a new scene
        Scene gameScene = new Scene(gameRoot);

        // Get the stage from the current event source
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene to the stage
        currentStage.setScene(gameScene);
    }

}
