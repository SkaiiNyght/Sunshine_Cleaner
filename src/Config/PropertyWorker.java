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
            properties.setProperty("conversionEquationB", config.getConversionEquationB());
            properties.setProperty("conversionMinimumB", config.getConversionMinimumB());
            properties.setProperty("masterCheckB", config.getMasterCheckB());
            properties.setProperty("conversionEquationCa", config.getConversionEquationCa());
            properties.setProperty("conversionMinimumCa", config.getConversionMinimumCa());
            properties.setProperty("masterCheckCa", config.getMasterCheckCa());
            properties.setProperty("conversionEquationCu", config.getConversionEquationCu());
            properties.setProperty("conversionMinimumCu", config.getConversionMinimumCu());
            properties.setProperty("masterCheckCu", config.getMasterCheckCu());
            properties.setProperty("conversionEquationFe", config.getConversionEquationFe());
            properties.setProperty("conversionMinimumFe", config.getConversionMinimumFe());
            properties.setProperty("masterCheckFe", config.getMasterCheckFe());
            properties.setProperty("conversionEquationK", config.getConversionEquationK());
            properties.setProperty("conversionMinimumK", config.getConversionMinimumK());
            properties.setProperty("masterCheckK", config.getMasterCheckK());
            properties.setProperty("conversionEquationMg", config.getConversionEquationMg());
            properties.setProperty("conversionMinimumMg", config.getConversionMinimumMg());
            properties.setProperty("masterCheckMg", config.getMasterCheckMg());
            properties.setProperty("conversionEquationMn", config.getConversionEquationMn());
            properties.setProperty("conversionMinimumMn", config.getConversionMinimumMn());
            properties.setProperty("masterCheckMn", config.getMasterCheckMn());
            properties.setProperty("conversionEquationNa", config.getConversionEquationNa());
            properties.setProperty("conversionMinimumNa", config.getConversionMinimumNa());
            properties.setProperty("masterCheckNa", config.getMasterCheckNa());
            properties.setProperty("conversionEquationS", config.getConversionEquationS());
            properties.setProperty("conversionMinimumS", config.getConversionMinimumS());
            properties.setProperty("masterCheckS", config.getMasterCheckS());
            properties.setProperty("conversionEquationZn", config.getConversionEquationZn());
            properties.setProperty("conversionMinimumZn", config.getConversionMinimumZn());
            properties.setProperty("masterCheckZn", config.getMasterCheckZn());
            properties.setProperty("dilutionFactor", config.getDilutionFactor());
            properties.setProperty("sulfurToSulfate", config.getSulfurToSulfate());
            
            File f = new File(fileLocation);
            OutputStream out = new FileOutputStream(f);
            properties.store(out, "Updated on " + new Date());
            out.close();
        } else {
            Message.Message.displayError("Verification Error", verifyMessage);
        }
    }

    /**
     * Determines if all of the properties have acceptable values
     * @param config the config class with all of the properties
     * @return Boolean
     */
    private String verifyProperties(Config config) {
        StringBuilder message = new StringBuilder();
        /*====================
        Ensure all minimums are doubles
        ====================*/
        try {
            Double.parseDouble(config.getConversionMinimumB());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Boron is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumCa());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Calcium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumCu());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Copper is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumFe());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Iron is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumK());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Potassium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumMg());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Magnesium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumMn());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Manganese is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumNa());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Sodium is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumS());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Sulfur is not a valid number.\n");
        }
        try {
            Double.parseDouble(config.getConversionMinimumZn());
        } catch (NumberFormatException nfe) {
            message.append("Minimum for Zinc is not a valid number.\n");
        }

        /*====================
        Ensure all equations have the word 'VALUE' in them
        ====================*/
        if (config.getConversionEquationB().contains("VALUE")) {
        } else {
            message.append("The equation for Boron must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationCa().contains("VALUE")) {
        } else {
            message.append("The equation for Calcium must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationCu().contains("VALUE")) {
        } else {
            message.append("The equation for Copper must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationFe().contains("VALUE")) {
        } else {
            message.append("The equation for Iron must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationK().contains("VALUE")) {
        } else {
            message.append("The equation for Potassium must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationMg().contains("VALUE")) {
        } else {
            message.append("The equation for Magnesium must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationMn().contains("VALUE")) {
        } else {
            message.append("The equation for Manganese must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationNa().contains("VALUE")) {
        } else {
            message.append("The equation for Sodium must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationS().contains("VALUE")) {
        } else {
            message.append("The equation for Sulfur must have the term 'VALUE' in it.\n");
        }
        if (config.getConversionEquationZn().contains("VALUE")) {
        } else {
            message.append("The equation for Zinc must have the term 'VALUE' in it.\n");
        }
        
        /*====================
        Ensure all check values are doubles
        ====================*/
        try{
            Double.parseDouble(config.getMasterCheckB());
        }catch(NumberFormatException nfe){
            message.append("Check value for Boron is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckCa());
        }catch(NumberFormatException nfe){
            message.append("Check value for Calcium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckCu());
        }catch(NumberFormatException nfe){
            message.append("Check value for Copper is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckFe());
        }catch(NumberFormatException nfe){
            message.append("Check value for Iron is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckK());
        }catch(NumberFormatException nfe){
            message.append("Check value for Potassium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckMg());
        }catch(NumberFormatException nfe){
            message.append("Check value for Magnesium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckMn());
        }catch(NumberFormatException nfe){
            message.append("Check value for Manganese is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckNa());
        }catch(NumberFormatException nfe){
            message.append("Check value for Sodium is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckS());
        }catch(NumberFormatException nfe){
            message.append("Check value for Sulfur is not a valid number.\n");
        }
        try{
            Double.parseDouble(config.getMasterCheckZn());
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
            Double.parseDouble(config.getSulfurToSulfate());
        }catch(NumberFormatException nfe){
            message.append("The Sulfur To Sulfate Multipler must be a valid number.");
        }
        return message.toString();
    }

    public Properties getProperties() {
        return properties;
    }

}
