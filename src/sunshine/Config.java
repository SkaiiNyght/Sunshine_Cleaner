/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunshine;

import Config.PropertyWorker;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Ag User
 */
public class Config {

    private TextField txtBoronMinimum;
    private TextField txtBoronEquation;
    private TextField txtCalciumMinimum;
    private TextField txtCalciumEquation;
    private TextField txtCopperMinimum;
    private TextField txtCopperEquation;
    private TextField txtIronMinimum;
    private TextField txtIronEquation;
    private TextField txtPotassiumMinimum;
    private TextField txtPotassiumEquation;
    private TextField txtMagnesiumMinimum;
    private TextField txtMagnesiumEquation;
    private TextField txtManganeseMinimum;
    private TextField txtManganeseEquation;
    private TextField txtSodiumMinimum;
    private TextField txtSodiumEquation;
    private TextField txtSulfurMinimum;
    private TextField txtSulfurEquation;
    private TextField txtZincMinimum;
    private TextField txtZincEquation;
    private TextField txtDilutionFactor;
    private TextField txtSulfurToSulfateMultiplier;
    private TextField txtBCheckValue;
    private TextField txtCaCheckValue;
    private TextField txtCuCheckValue;
    private TextField txtFeCheckValue;
    private TextField txtKCheckValue;
    private TextField txtMgCheckValue;
    private TextField txtMnCheckValue;
    private TextField txtNaCheckValue;
    private TextField txtSCheckValue;
    private TextField txtZnCheckValue;
    private PropertyWorker propWorker;

    public Config() {
        displayConfigurations();
    }

    private void displayConfigurations() {
        propWorker = null;
        try {
            propWorker = new PropertyWorker();
        } catch (IOException ioe) {
            Message.Message.displayError("Closing Config File", "An Error occurred"
                    + " when attempting to close the configuration file.\n" + ioe.getMessage());
            System.exit(0);
        }
        Properties props = propWorker.getProperties();

        Stage window = new Stage();
        window.setOnCloseRequest(request -> {
            window.close();
        });

        /*====================
        Pane for the whole form
        ====================*/
        Pane background = new Pane();

        /*====================
        GridPane #1 (Minimums and Equations)
        ====================*/
        GridPane gridPane1 = new GridPane();

        /*====================
        GridPane #1 Labels
        ====================*/
        Label lblElements = new Label("Elements");
        Label lblBoron = new Label("Boron");
        Label lblCalcium = new Label("Calcium");
        Label lblCopper = new Label("Copper");
        Label lblIron = new Label("Iron");
        Label lblPotassium = new Label("Potassium");
        Label lblMagnesium = new Label("Magnesium");
        Label lblManganese = new Label("Manganese");
        Label lblSodium = new Label("Sodium");
        Label lblSulfur = new Label("Sulfer");
        Label lblZinc = new Label("Zinc");
        Label lblMinimums = new Label("Minimums");
        Label lblConversionEquations = new Label("Conversion Equations");
        Label lblCheckValues = new Label("Check Values");

        /*====================
        GridPane #1 TextFields
        ====================*/
        txtBoronMinimum = new TextField(props.getProperty("conversionMinimumB"));
        txtBoronEquation = new TextField(props.getProperty("conversionEquationB"));
        txtBCheckValue = new TextField(props.getProperty("masterCheckB"));
        txtCalciumMinimum = new TextField(props.getProperty("conversionMinimumCa"));
        txtCalciumEquation = new TextField(props.getProperty("conversionEquationCa"));
        txtCaCheckValue = new TextField(props.getProperty("masterCheckCa"));
        txtCopperMinimum = new TextField(props.getProperty("conversionMinimumCu"));
        txtCopperEquation = new TextField(props.getProperty("conversionEquationCu"));
        txtCuCheckValue = new TextField(props.getProperty("masterCheckCu"));
        txtIronMinimum = new TextField(props.getProperty("conversionMinimumFe"));
        txtIronEquation = new TextField(props.getProperty("conversionEquationFe"));
        txtFeCheckValue = new TextField(props.getProperty("masterCheckFe"));
        txtPotassiumMinimum = new TextField(props.getProperty("conversionMinimumK"));
        txtPotassiumEquation = new TextField(props.getProperty("conversionEquationK"));
        txtKCheckValue = new TextField(props.getProperty("masterCheckK"));
        txtMagnesiumMinimum = new TextField(props.getProperty("conversionMinimumMg"));
        txtMagnesiumEquation = new TextField(props.getProperty("conversionEquationMg"));
        txtMgCheckValue = new TextField(props.getProperty("masterCheckMg"));
        txtManganeseMinimum = new TextField(props.getProperty("conversionMinimumMn"));
        txtManganeseEquation = new TextField(props.getProperty("conversionEquationMn"));
        txtMnCheckValue = new TextField(props.getProperty("masterCheckMn"));
        txtSodiumMinimum = new TextField(props.getProperty("conversionMinimumNa"));
        txtSodiumEquation = new TextField(props.getProperty("conversionEquationNa"));
        txtNaCheckValue = new TextField(props.getProperty("masterCheckNa"));
        txtSulfurMinimum = new TextField(props.getProperty("conversionMinimumS"));
        txtSulfurEquation = new TextField(props.getProperty("conversionEquationS"));
        txtSCheckValue = new TextField(props.getProperty("masterCheckS"));
        txtZincMinimum = new TextField(props.getProperty("conversionMinimumZn"));
        txtZincEquation = new TextField(props.getProperty("conversionEquationZn"));
        txtZnCheckValue = new TextField(props.getProperty("masterCheckZn"));

        /*====================
        Assign grid indexes for GridPane #1 items
        ====================*/
        GridPane.setConstraints(lblElements, 0, 0);
        GridPane.setConstraints(lblMinimums, 1, 0);
        GridPane.setConstraints(lblConversionEquations, 2, 0);
        GridPane.setConstraints(lblCheckValues, 3, 0);
        GridPane.setConstraints(lblBoron, 0, 1);
        GridPane.setConstraints(txtBoronMinimum, 1, 1);
        GridPane.setConstraints(txtBoronEquation, 2, 1);
        GridPane.setConstraints(txtBCheckValue, 3, 1);
        GridPane.setConstraints(lblCalcium, 0, 2);
        GridPane.setConstraints(txtCalciumMinimum, 1, 2);
        GridPane.setConstraints(txtCalciumEquation, 2, 2);
        GridPane.setConstraints(txtCaCheckValue, 3, 2);
        GridPane.setConstraints(lblCopper, 0, 3);
        GridPane.setConstraints(txtCopperMinimum, 1, 3);
        GridPane.setConstraints(txtCopperEquation, 2, 3);
        GridPane.setConstraints(txtCuCheckValue, 3, 3);
        GridPane.setConstraints(lblIron, 0, 4);
        GridPane.setConstraints(txtIronMinimum, 1, 4);
        GridPane.setConstraints(txtIronEquation, 2, 4);
        GridPane.setConstraints(txtFeCheckValue, 3, 4);
        GridPane.setConstraints(lblPotassium, 0, 5);
        GridPane.setConstraints(txtPotassiumMinimum, 1, 5);
        GridPane.setConstraints(txtPotassiumEquation, 2, 5);
        GridPane.setConstraints(txtKCheckValue, 3, 5);
        GridPane.setConstraints(lblMagnesium, 0, 6);
        GridPane.setConstraints(txtMagnesiumMinimum, 1, 6);
        GridPane.setConstraints(txtMagnesiumEquation, 2, 6);
        GridPane.setConstraints(txtMgCheckValue, 3, 6);
        GridPane.setConstraints(lblManganese, 0, 7);
        GridPane.setConstraints(txtManganeseMinimum, 1, 7);
        GridPane.setConstraints(txtManganeseEquation, 2, 7);
        GridPane.setConstraints(txtMnCheckValue, 3, 7);
        GridPane.setConstraints(lblSodium, 0, 8);
        GridPane.setConstraints(txtSodiumMinimum, 1, 8);
        GridPane.setConstraints(txtSodiumEquation, 2, 8);
        GridPane.setConstraints(txtNaCheckValue, 3, 8);
        GridPane.setConstraints(lblSulfur, 0, 9);
        GridPane.setConstraints(txtSulfurMinimum, 1, 9);
        GridPane.setConstraints(txtSulfurEquation, 2, 9);
        GridPane.setConstraints(txtSCheckValue, 3, 9);
        GridPane.setConstraints(lblZinc, 0, 10);
        GridPane.setConstraints(txtZincMinimum, 1, 10);
        GridPane.setConstraints(txtZincEquation, 2, 10);
        GridPane.setConstraints(txtZnCheckValue, 3, 10);

        /*====================
        Add Items to GridPane #1
        ====================*/
        gridPane1.getChildren().addAll(lblBoron, lblCalcium, lblConversionEquations, lblCopper, lblElements, lblIron, lblMagnesium, lblManganese, lblMinimums, lblPotassium, lblSodium, lblSulfur, lblZinc, lblCheckValues,
                txtBoronMinimum, txtCalciumMinimum, txtCopperMinimum, txtIronMinimum,
                txtPotassiumMinimum, txtMagnesiumMinimum, txtManganeseMinimum,
                txtSodiumMinimum, txtSulfurMinimum, txtZincMinimum,
                txtBoronEquation, txtCalciumEquation, txtCopperEquation,
                txtIronEquation, txtPotassiumEquation, txtMagnesiumEquation,
                txtManganeseEquation, txtSodiumEquation, txtSulfurEquation,
                txtZincEquation, txtBCheckValue, txtCaCheckValue, txtCuCheckValue,
                txtFeCheckValue, txtKCheckValue, txtMgCheckValue, txtMnCheckValue, 
                txtNaCheckValue, txtSCheckValue, txtZnCheckValue);

        /*====================
        GridPane #2 (Dilution Factor, Sulfur to Sulfate Multiplier, and buttons
        ====================*/
        GridPane gridPane2 = new GridPane();

        /*====================
        Grid Pane #2 labels
        ====================*/
        Label lblDilutionFactor = new Label("Dilution Factor");
        Label lblSulfurToSulfateMultiplier = new Label("Sulfur To Sulfate Multipler");

        /*====================
        Grid Pane #2 TextFields
        ====================*/
        txtDilutionFactor = new TextField(props.getProperty("dilutionFactor"));
        txtSulfurToSulfateMultiplier = new TextField(props.getProperty("sulfurToSulfate"));

        /*====================
        Grid Pane #2 Buttons
        ====================*/
        Button btnSave = new Button("Save");
        btnSave.setOnAction(event -> {
            try{
                attemptSave(propWorker);
            }catch(IOException ioe){
                Message.Message.displayError("Saving Config File", "An error occurred while saving the config file. \n" + ioe.getMessage());
            }
            
            window.close();
        });

        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> {
            window.close();
        });

        /*====================
        Assign grid indexes for GridPane #2 Items
        ====================*/
        GridPane.setConstraints(lblDilutionFactor, 0, 0);
        GridPane.setConstraints(txtDilutionFactor, 1, 0);
        GridPane.setConstraints(lblSulfurToSulfateMultiplier, 0, 1);
        GridPane.setConstraints(txtSulfurToSulfateMultiplier, 1, 1);
        GridPane.setConstraints(btnSave, 0, 2);
        GridPane.setConstraints(btnCancel, 1, 2);

        /*====================
        Add items to GridPane #2
        ====================*/
        gridPane2.getChildren().addAll(lblDilutionFactor, lblSulfurToSulfateMultiplier, txtDilutionFactor, txtSulfurToSulfateMultiplier,
                btnSave, btnCancel);

        /*====================
        Add items to background pane and arrange them
        ====================*/
        gridPane1.setLayoutX(10);
        gridPane1.setLayoutY(0);
        gridPane1.setPadding(new Insets(5, 5, 5, 5));
        gridPane2.setLayoutX(100);
        gridPane2.setLayoutY(274);
        gridPane2.setPadding(new Insets(5, 5, 5, 5));
        background.getChildren().addAll(gridPane1, gridPane2);

        /*====================
        Create Scene
        ====================*/
        Scene scene = new Scene(background);

        /*====================
        Display window
        ====================*/
        window.getIcons().add(new Image(getClass().getResourceAsStream("config.png")));
        window.setScene(scene);
        window.setTitle("Configurations");
        window.showAndWait();
    }
    public void attemptSave(PropertyWorker propWorker) throws IOException{
        propWorker.saveProperties(this);
    }
    public String getBoronMinimum() {
        return txtBoronMinimum.getText();
    }

    public String getBoronEquation() {
        return txtBoronEquation.getText();
    }

    public String getCalciumMinimum() {
        return txtCalciumMinimum.getText();
    }

    public String getCalciumEquation() {
        return txtCalciumEquation.getText();
    }

    public String getCopperMinimum() {
        return txtCopperMinimum.getText();
    }

    public String getCopperEquation() {
        return txtCopperEquation.getText();
    }

    public String getIronMinimum() {
        return txtIronMinimum.getText();
    }

    public String getIronEquation() {
        return txtIronEquation.getText();
    }

    public String getPotassiumMinimum() {
        return txtPotassiumMinimum.getText();
    }

    public String getPotassiumEquation() {
        return txtPotassiumEquation.getText();
    }

    public String getMagnesiumMinimum() {
        return txtMagnesiumMinimum.getText();
    }

    public String getMagnesiumEquation() {
        return txtMagnesiumEquation.getText();
    }

    public String getManganeseMinimum() {
        return txtManganeseMinimum.getText();
    }

    public String getManganeseEquation() {
        return txtManganeseEquation.getText();
    }

    public String getSodiumMinimum() {
        return txtSodiumMinimum.getText();
    }

    public String getSodiumEquation() {
        return txtSodiumEquation.getText();
    }

    public String getSulfurMinimum() {
        return txtSulfurMinimum.getText();
    }

    public String getSulfurEquation() {
        return txtSulfurEquation.getText();
    }

    public String getZincMinimum() {
        return txtZincMinimum.getText();
    }

    public String getZincEquation() {
        return txtZincEquation.getText();
    }

    public String getDilutionFactor() {
        return txtDilutionFactor.getText();
    }

    public String getSulfurToSulfateMultiplier() {
        return txtSulfurToSulfateMultiplier.getText();
    }

    public String getBCheckValue() {
        return txtBCheckValue.getText();
    }

    public String getCaCheckValue() {
        return txtCaCheckValue.getText();
    }

    public String getCuCheckValue() {
        return txtCuCheckValue.getText();
    }

    public String getFeCheckValue() {
        return txtFeCheckValue.getText();
    }

    public String getKCheckValue() {
        return txtKCheckValue.getText();
    }

    public String getMgCheckValue() {
        return txtMgCheckValue.getText();
    }

    public String getMnCheckValue() {
        return txtMnCheckValue.getText();
    }

    public String getNaCheckValue() {
        return txtNaCheckValue.getText();
    }

    public String getSCheckValue() {
        return txtSCheckValue.getText();
    }

    public String getZnCheckValue() {
        return txtZnCheckValue.getText();
    }
    
    
}
