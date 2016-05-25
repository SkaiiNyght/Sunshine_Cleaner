package Message;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Zach Larson
 */
public class Message {
    /**
     * Display an error message to the user
     * @param header the title of the message
     * @param content the content of the message.
     */
    public static void displayError(String header, String content){
        Stage window = new Stage();
        
        window.setTitle("ERROR: " + header);
        window.setWidth(1000);
        
        Label label = new Label(content);
        GridPane.setConstraints(label, 0, 0);
        
        GridPane layout = new GridPane();
        layout.getChildren().addAll(label);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.showAndWait();
    }
}
