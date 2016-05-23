package sunshine;

import Controller.FinalizeButton;
import Controller.PreCleanButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Zach Larson
 * @version 1.0
 * 
 * This program has two abilities.
 *  1. Take in a xls file (raw), and output a csv file (pre-cleaned)
 *  2. Take in a csv file (pre-cleaned), and output a csv file (finalized)
 * 
 * This is to be used when doing Sunshine test runs on the ICP to clean up files, 
 * and apply correction factors, dilutions, and conversion equations.
 * 
 * 
 */
public class Sunshine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox outerWrapper = new HBox(); //Outer wrapper
        GridPane innerWrapper = new GridPane(); //Inner wrapper
        innerWrapper.setHgap(10);
        /*============================
        Preclean Wrapper and Button
        ============================*/
        Pane precleanWrapper = new Pane();
        precleanWrapper.setMinWidth(150);
        precleanWrapper.setMinHeight(75);
        GridPane.setConstraints(precleanWrapper, 0, 0);
        Button precleanButton = new Button("Pre-Clean");
        precleanButton.setLayoutX(50);
        precleanButton.setLayoutY(28);
        precleanButton.setPadding(new Insets(5,5,5,5));
        precleanButton.setOnAction(e ->{
            PreCleanButton.onClick();
        });
        
        /*============================
        Finalize Wrapper and Button
        ============================*/
        Pane finalizeWrapper = new Pane();
        finalizeWrapper.setMinWidth(150);
        finalizeWrapper.setMinHeight(75);
        GridPane.setConstraints(finalizeWrapper, 1, 0);
        Button finalizeButton = new Button("Finalize");
        finalizeButton.setLayoutX(50);
        finalizeButton.setLayoutY(28);
        finalizeButton.setPadding(new Insets(5,5,5,5));
        finalizeButton.setOnAction(e -> {
            try{
                FinalizeButton.onClick();
            }catch(Exception ex){
                ex.printStackTrace();
            }
           
        });
        
        /*============================
        Add Items to their wrappers
        ============================*/
        precleanWrapper.getChildren().addAll(precleanButton);
        finalizeWrapper.getChildren().addAll(finalizeButton);
        innerWrapper.getChildren().addAll(precleanWrapper, finalizeWrapper);
        outerWrapper.getChildren().addAll(innerWrapper);
        
        /*============================
        Add Scene and display
        ============================*/
        Scene scene = new Scene(outerWrapper);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sunshine");
        primaryStage.setResizable(Boolean.FALSE);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
