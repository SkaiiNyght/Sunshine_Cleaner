package sunshine;

import Config.PropertyWorker;
import java.io.IOException;
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
 * @author Zach Larson
 */
public class Config {

    //Conversion Equations
    private TextField txtConversionEquationB;
    private TextField txtConversionEquationCa;
    private TextField txtConversionEquationCu;
    private TextField txtConversionEquationFe;
    private TextField txtConversionEquationK;
    private TextField txtConversionEquationMg;
    private TextField txtConversionEquationMn;
    private TextField txtConversionEquationNa;
    private TextField txtConversionEquationS;
    private TextField txtConversionEquationZn;
    
    //Conversion Minimums
    private TextField txtConversionMinimumB;
    private TextField txtConversionMinimumCa;
    private TextField txtConversionMinimumCu;
    private TextField txtConversionMinimumFe;
    private TextField txtConversionMinimumK;
    private TextField txtConversionMinimumMg;
    private TextField txtConversionMinimumMn;
    private TextField txtConversionMinimumNa;
    private TextField txtConversionMinimumS;
    private TextField txtConversionMinimumZn;
    
    //Master Check Values
    private TextField txtMasterCheckB;
    private TextField txtMasterCheckCa;
    private TextField txtMasterCheckCu;
    private TextField txtMasterCheckFe;
    private TextField txtMasterCheckK;
    private TextField txtMasterCheckMg;
    private TextField txtMasterCheckMn;
    private TextField txtMasterCheckNa;
    private TextField txtMasterCheckS;
    private TextField txtMasterCheckZn;
    
    //PropertyWorker
    private PropertyWorker propWorker;
    
    //SulfurToSulfate
    private TextField txtSulfurToSulfate;
    
    //Dilution Factor
    private TextField txtDilutionFactor;
    
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
        txtConversionMinimumB = new TextField(props.getProperty("conversionMinimumB"));
        txtConversionEquationB = new TextField(props.getProperty("conversionEquationB"));
        txtMasterCheckB = new TextField(props.getProperty("masterCheckB"));
        txtConversionMinimumCa = new TextField(props.getProperty("conversionMinimumCa"));
        txtConversionEquationCa = new TextField(props.getProperty("conversionEquationCa"));
        txtMasterCheckCa = new TextField(props.getProperty("masterCheckCa"));
        txtConversionMinimumCu = new TextField(props.getProperty("conversionMinimumCu"));
        txtConversionEquationCu = new TextField(props.getProperty("conversionEquationCu"));
        txtMasterCheckCu = new TextField(props.getProperty("masterCheckCu"));
        txtConversionMinimumFe = new TextField(props.getProperty("conversionMinimumFe"));
        txtConversionEquationFe = new TextField(props.getProperty("conversionEquationFe"));
        txtMasterCheckFe = new TextField(props.getProperty("masterCheckFe"));
        txtConversionMinimumK = new TextField(props.getProperty("conversionMinimumK"));
        txtConversionEquationK = new TextField(props.getProperty("conversionEquationK"));
        txtMasterCheckK = new TextField(props.getProperty("masterCheckK"));
        txtConversionMinimumMg = new TextField(props.getProperty("conversionMinimumMg"));
        txtConversionEquationMg = new TextField(props.getProperty("conversionEquationMg"));
        txtMasterCheckMg = new TextField(props.getProperty("masterCheckMg"));
        txtConversionMinimumMn = new TextField(props.getProperty("conversionMinimumMn"));
        txtConversionEquationMn = new TextField(props.getProperty("conversionEquationMn"));
        txtMasterCheckMn = new TextField(props.getProperty("masterCheckMn"));
        txtConversionMinimumNa = new TextField(props.getProperty("conversionMinimumNa"));
        txtConversionEquationNa = new TextField(props.getProperty("conversionEquationNa"));
        txtMasterCheckNa = new TextField(props.getProperty("masterCheckNa"));
        txtConversionMinimumS = new TextField(props.getProperty("conversionMinimumS"));
        txtConversionEquationS = new TextField(props.getProperty("conversionEquationS"));
        txtMasterCheckS = new TextField(props.getProperty("masterCheckS"));
        txtConversionMinimumZn = new TextField(props.getProperty("conversionMinimumZn"));
        txtConversionEquationZn = new TextField(props.getProperty("conversionEquationZn"));
        txtMasterCheckZn = new TextField(props.getProperty("masterCheckZn"));

        /*====================
        Assign grid indexes for GridPane #1 items
        ====================*/
        GridPane.setConstraints(lblElements, 0, 0);
        GridPane.setConstraints(lblMinimums, 1, 0);
        GridPane.setConstraints(lblConversionEquations, 2, 0);
        GridPane.setConstraints(lblCheckValues, 3, 0);
        GridPane.setConstraints(lblBoron, 0, 1);
        GridPane.setConstraints(txtConversionMinimumB, 1, 1);
        GridPane.setConstraints(txtConversionEquationB, 2, 1);
        GridPane.setConstraints(txtMasterCheckB, 3, 1);
        GridPane.setConstraints(lblCalcium, 0, 2);
        GridPane.setConstraints(txtConversionMinimumCa, 1, 2);
        GridPane.setConstraints(txtConversionEquationCa, 2, 2);
        GridPane.setConstraints(txtMasterCheckCa, 3, 2);
        GridPane.setConstraints(lblCopper, 0, 3);
        GridPane.setConstraints(txtConversionMinimumCu, 1, 3);
        GridPane.setConstraints(txtConversionEquationCu, 2, 3);
        GridPane.setConstraints(txtMasterCheckCu, 3, 3);
        GridPane.setConstraints(lblIron, 0, 4);
        GridPane.setConstraints(txtConversionMinimumFe, 1, 4);
        GridPane.setConstraints(txtConversionEquationFe, 2, 4);
        GridPane.setConstraints(txtMasterCheckFe, 3, 4);
        GridPane.setConstraints(lblPotassium, 0, 5);
        GridPane.setConstraints(txtConversionMinimumK, 1, 5);
        GridPane.setConstraints(txtConversionEquationK, 2, 5);
        GridPane.setConstraints(txtMasterCheckK, 3, 5);
        GridPane.setConstraints(lblMagnesium, 0, 6);
        GridPane.setConstraints(txtConversionMinimumMg, 1, 6);
        GridPane.setConstraints(txtConversionEquationMg, 2, 6);
        GridPane.setConstraints(txtMasterCheckMg, 3, 6);
        GridPane.setConstraints(lblManganese, 0, 7);
        GridPane.setConstraints(txtConversionMinimumMn, 1, 7);
        GridPane.setConstraints(txtConversionEquationMn, 2, 7);
        GridPane.setConstraints(txtMasterCheckMn, 3, 7);
        GridPane.setConstraints(lblSodium, 0, 8);
        GridPane.setConstraints(txtConversionMinimumNa, 1, 8);
        GridPane.setConstraints(txtConversionEquationNa, 2, 8);
        GridPane.setConstraints(txtMasterCheckNa, 3, 8);
        GridPane.setConstraints(lblSulfur, 0, 9);
        GridPane.setConstraints(txtConversionMinimumS, 1, 9);
        GridPane.setConstraints(txtConversionEquationS, 2, 9);
        GridPane.setConstraints(txtMasterCheckS, 3, 9);
        GridPane.setConstraints(lblZinc, 0, 10);
        GridPane.setConstraints(txtConversionMinimumZn, 1, 10);
        GridPane.setConstraints(txtConversionEquationZn, 2, 10);
        GridPane.setConstraints(txtMasterCheckZn, 3, 10);

        /*====================
        Add Items to GridPane #1
        ====================*/
        gridPane1.getChildren().addAll(lblBoron, lblCalcium, lblConversionEquations, lblCopper, lblElements, lblIron, lblMagnesium, lblManganese, lblMinimums, lblPotassium, lblSodium, lblSulfur, lblZinc, lblCheckValues,
                txtConversionMinimumB, txtConversionMinimumCa, txtConversionMinimumCu, txtConversionMinimumFe,
                txtConversionMinimumK, txtConversionMinimumMg, txtConversionMinimumMn,
                txtConversionMinimumNa, txtConversionMinimumS, txtConversionMinimumZn,
                txtConversionEquationB, txtConversionEquationCa, txtConversionEquationCu,
                txtConversionEquationFe, txtConversionEquationK, txtConversionEquationMg,
                txtConversionEquationMn, txtConversionEquationNa, txtConversionEquationS,
                txtConversionEquationZn, txtMasterCheckB, txtMasterCheckCa, txtMasterCheckCu,
                txtMasterCheckFe, txtMasterCheckK, txtMasterCheckMg, txtMasterCheckMn, 
                txtMasterCheckNa, txtMasterCheckS, txtMasterCheckZn);

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
        txtSulfurToSulfate = new TextField(props.getProperty("sulfurToSulfate"));

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
        GridPane.setConstraints(txtSulfurToSulfate, 1, 1);
        GridPane.setConstraints(btnSave, 0, 2);
        GridPane.setConstraints(btnCancel, 1, 2);

        /*====================
        Add items to GridPane #2
        ====================*/
        gridPane2.getChildren().addAll(lblDilutionFactor, lblSulfurToSulfateMultiplier, txtDilutionFactor, txtSulfurToSulfate,
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
    
    /**
     * returns the conversion minimum for Boron
     * @return String
     */
    public String getConversionMinimumB() {
        return txtConversionMinimumB.getText();
    }

    /**
     * returns the conversion equation for Boron
     * @return String
     */
    public String getConversionEquationB() {
        return txtConversionEquationB.getText();
    }

    /**
     * returns the conversion minimum for Calcium
     * @return String
     */
    public String getConversionMinimumCa() {
        return txtConversionMinimumCa.getText();
    }

    /**
     * returns the conversion equation for Calcium
     * @return String
     */
    public String getConversionEquationCa() {
        return txtConversionEquationCa.getText();
    }

    /**
     * returns the conversion minimum for Copper
     * @return String
     */
    public String getConversionMinimumCu() {
        return txtConversionMinimumCu.getText();
    }

    /**
     * returns the conversion equation for Copper
     * @return String
     */
    public String getConversionEquationCu() {
        return txtConversionEquationCu.getText();
    }

    /**
     * returns the conversion minimum for Iron
     * @return String
     */
    public String getConversionMinimumFe() {
        return txtConversionMinimumFe.getText();
    }

    /**
     * returns the conversion equation for Iron
     * @return String
     */
    public String getConversionEquationFe() {
        return txtConversionEquationFe.getText();
    }

    /**
     * returns the conversion minimum for Potassium
     * @return String
     */
    public String getConversionMinimumK() {
        return txtConversionMinimumK.getText();
    }

    /**
     * returns the conversion equation for Potassium
     * @return String
     */
    public String getConversionEquationK() {
        return txtConversionEquationK.getText();
    }

    /**
     * returns the conversion minimum for Magnesium
     * @return String
     */
    public String getConversionMinimumMg() {
        return txtConversionMinimumMg.getText();
    }

    /**
     * returns the conversion equation for Magnesium
     * @return String
     */
    public String getConversionEquationMg() {
        return txtConversionEquationMg.getText();
    }

    /**
     * returns the conversion minimum for Manganese
     * @return String
     */
    public String getConversionMinimumMn() {
        return txtConversionMinimumMn.getText();
    }

    /**
     * returns the conversion equation for Manganese
     * @return String
     */
    public String getConversionEquationMn() {
        return txtConversionEquationMn.getText();
    }

    /**
     * returns the conversion conversion minimum for Sodium
     * @return String
     */
    public String getConversionMinimumNa() {
        return txtConversionMinimumNa.getText();
    }

    /**
     * returns the conversion equation for Sodium
     * @return String
     */
    public String getConversionEquationNa() {
        return txtConversionEquationNa.getText();
    }

    /**
     * returns the conversion minimum for Sulfur
     * @return String
     */
    public String getConversionMinimumS() {
        return txtConversionMinimumS.getText();
    }

    /**
     * returns the conversion equation for Sulfur
     * @return String
     */
    public String getConversionEquationS() {
        return txtConversionEquationS.getText();
    }

    /**
     * returns the conversion minimum for Zinc
     * @return String
     */
    public String getConversionMinimumZn() {
        return txtConversionMinimumZn.getText();
    }

    /**
     * returns the conversion equation for Zinc
     * @return String
     */
    public String getConversionEquationZn() {
        return txtConversionEquationZn.getText();
    }

    /**
     * returns the Dilution Factor
     * @return String
     */
    public String getDilutionFactor() {
        return txtDilutionFactor.getText();
    }

    /**
     * returns the Sulfur to Sulfate multiplier
     * @return String
     */
    public String getSulfurToSulfate() {
        return txtSulfurToSulfate.getText();
    }

    /**
     * returns the master check value for Boron
     * @return String
     */
    public String getMasterCheckB() {
        return txtMasterCheckB.getText();
    }

    /**
     * returns the master check value for Calcium
     * @return String
     */
    public String getMasterCheckCa() {
        return txtMasterCheckCa.getText();
    }

    /**
     * returns the master check value for Copper
     * @return String
     */
    public String getMasterCheckCu() {
        return txtMasterCheckCu.getText();
    }

    /**
     * returns the master check value for Iron
     * @return String
     */
    public String getMasterCheckFe() {
        return txtMasterCheckFe.getText();
    }

    /**
     * returns the master check value for Potassium
     * @return String
     */
    public String getMasterCheckK() {
        return txtMasterCheckK.getText();
    }

    /**
     * returns the master check value for Magnesium
     * @return String
     */
    public String getMasterCheckMg() {
        return txtMasterCheckMg.getText();
    }

    /**
     * returns the master check value for Manganese
     * @return String
     */
    public String getMasterCheckMn() {
        return txtMasterCheckMn.getText();
    }

    /**
     * returns the master check value for Sodium
     * @return String
     */
    public String getMasterCheckNa() {
        return txtMasterCheckNa.getText();
    }

    /**
     * returns the master check value for Sulfur
     * @return String
     */
    public String getMasterCheckS() {
        return txtMasterCheckS.getText();
    }

    /**
     * returns the master check value for Zinc
     * @return String
     */
    public String getMasterCheckZn() {
        return txtMasterCheckZn.getText();
    }
    
    
}
