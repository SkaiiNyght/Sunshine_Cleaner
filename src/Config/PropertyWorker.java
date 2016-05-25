/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import sunshine.Config;

/**
 *
 * @author Ag User
 */
public class PropertyWorker {

    Properties properties;
    private final String fileLocation = "./src/configuration.properties";

    public PropertyWorker() throws IOException {
        loadProperties();
    }

    private void loadProperties() throws IOException {
        
        FileReader fr = null;
        try {
            properties = new Properties();
            fr= new FileReader(new File(fileLocation));
           
             properties.load(fr);
            
            
        }catch (IOException ioe) {
            Message.Message.displayError("File IO", "An error occured when doing"
                    + " opertaions with the configuration file.\n" + ioe.getMessage());
                    System.exit(0);
        } catch (Exception ex) {
            Message.Message.displayError("Unkown Error", "An unknown error occured."
                    + "\n" + ex.getMessage());
                    System.exit(0);
        } finally {
            fr.close();
        }
    }

    public void saveProperties(Config config) throws IOException {
        String verifyMessage = verifyProperties(config);
        if (verifyMessage.isEmpty()) {
            
            properties.setProperty("conversionEquationB", config.getBoronEquation());
            properties.setProperty("conversionMinimumB", config.getBoronMinimum());
            properties.setProperty("masterCheckB", config.getBCheckValue());
            properties.setProperty("conversionEquationCa", config.getCalciumEquation());
            properties.setProperty("conversionMinimumCa", config.getCalciumMinimum());
            properties.setProperty("masterCheckCa", config.getCaCheckValue());
            properties.setProperty("conversionEquationCu", config.getCopperEquation());
            properties.setProperty("conversionMinimumCu", config.getCopperMinimum());
            properties.setProperty("masterCheckCu", config.getCuCheckValue());
            properties.setProperty("conversionEquationFe", config.getIronEquation());
            properties.setProperty("conversionMinimumFe", config.getIronMinimum());
            properties.setProperty("masterCheckFe", config.getFeCheckValue());
            properties.setProperty("conversionEquationK", config.getPotassiumEquation());
            properties.setProperty("conversionMinimumK", config.getPotassiumMinimum());
            properties.setProperty("masterCheckK", config.getKCheckValue());
            properties.setProperty("conversionEquationMg", config.getMagnesiumEquation());
            properties.setProperty("conversionMinimumMg", config.getMagnesiumMinimum());
            properties.setProperty("masterCheckMg", config.getMgCheckValue());
            properties.setProperty("conversionEquationMn", config.getManganeseEquation());
            properties.setProperty("conversionMinimumMn", config.getManganeseMinimum());
            properties.setProperty("masterCheckMn", config.getMnCheckValue());
            properties.setProperty("conversionEquationNa", config.getSodiumEquation());
            properties.setProperty("conversionMinimumNa", config.getSodiumMinimum());
            properties.setProperty("masterCheckNa", config.getNaCheckValue());
            properties.setProperty("conversionEquationS", config.getSulfurEquation());
            properties.setProperty("conversionMinimumS", config.getSulfurMinimum());
            properties.setProperty("masterCheckS", config.getSCheckValue());
            properties.setProperty("conversionEquationZn", config.getZincEquation());
            properties.setProperty("conversionMinimumZn", config.getZincMinimum());
            properties.setProperty("masterCheckZn", config.getZnCheckValue());
            properties.setProperty("dilutionFactor", config.getDilutionFactor());
            properties.setProperty("sulfurToSulfate", config.getSulfurToSulfateMultiplier());
            
            File f = new File(fileLocation);
            OutputStream out = new FileOutputStream(f);
            properties.store(out, "Updated on " + new Date());
            out.close();
        } else {
            Message.Message.displayError("Verification Error", verifyMessage);
        }
    }

    private String verifyProperties(Config config) {
        StringBuilder message = new StringBuilder();
        /*====================
        Ensure all minimums are doubles
        ====================*/
        try {
            Double.parseDouble(config.getBoronMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Boron is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getCalciumMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Calcium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getCopperMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Copper is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getIronMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Iron is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getPotassiumMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Potassium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getMagnesiumMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Magnesium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getManganeseMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Manganese is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getSodiumMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Sodium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getSulfurMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Sulfur is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getZincMinimum());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Zinc is not a valid number.\n");
        }

        /*====================
        Ensure all equations have the word 'VALUE' in them
        ====================*/
        if (config.getBoronEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Boron must have the term 'VALUE' in it.\n");
        }
        if (config.getCalciumEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Calcium must have the term 'VALUE' in it.\n");
        }
        if (config.getCopperEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Copper must have the term 'VALUE' in it.\n");
        }
        if (config.getIronEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Iron must have the term 'VALUE' in it.\n");
        }
        if (config.getPotassiumEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Potassium must have the term 'VALUE' in it.\n");
        }
        if (config.getMagnesiumEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Magnesium must have the term 'VALUE' in it.\n");
        }
        if (config.getManganeseEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Manganese must have the term 'VALUE' in it.\n");
        }
        if (config.getSodiumEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Sodium must have the term 'VALUE' in it.\n");
        }
        if (config.getSulfurEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Sulfur must have the term 'VALUE' in it.\n");
        }
        if (config.getZincEquation().contains("VALUE")) {
        } else {
            message.append("The equation for Zinc must have the term 'VALUE' in it.\n");
        }
        
        /*====================
        Ensure all check values are doubles
        ====================*/
        try{
            Double.parseDouble(config.getBCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Boron is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getCaCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Calcium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getCuCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Copper is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getFeCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Iron is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getKCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Potassium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMgCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Magnesium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMnCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Manganese is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getNaCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Sodium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getSCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Sulfur is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getZnCheckValue());
        }catch(NumberFormatException nfe){
            message.append("Check value for Zinc is not a valid number.\n");
        }
        /*====================
        Ensure DilutionFactor and Sulfur To Sulfate Multiplier are both Doubles
        ====================*/
        try{
            Double.parseDouble(config.getDilutionFactor());
        }catch(NumberFormatException nfe){
            message.append("The dilution factor must be a valid number.");
        }
        try{
            Double.parseDouble(config.getSulfurToSulfateMultiplier());
        }catch(NumberFormatException nfe){
            message.append("The Sulfur To Sulfate Multipler must be a valid number.");
        }
        return message.toString();
    }

    public Properties getProperties() {
        return properties;
    }

}
