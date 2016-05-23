package Controller;

import CSV.CSV;
import CSV.XLSToCSV;
import Config.JSONReader;
import Model.Check;
import Model.PreCleanIndexer;
import Model.Sample;
import Model.SampleAndCheck;
import Model.SunshineConversion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javafx.stage.FileChooser;

/**
 *
 * @author Zach Larson
 */
public class PreCleanButton {
    /**
     * Reads in a raw XLS file and outputs a pre-cleaned output CSV file
     */
    public static void onClick(){
        
        /*====================
        jsonObjects indexes: 0 - Dilution Factor, 1 - MasterCheck, 
        2 - Conversion Minimums, 3 - Conversion Equations
        ====================*/
        Object[] jsonObjects = JSONReader.getJSONObjects();
        
        File xcelFile = openFile();
        File convertedFile = XLSToCSV.convertXLSToCSV(xcelFile);
        SampleAndCheck parsedSamples = null;
        try{
            parsedSamples = parseCSV(convertedFile, (Map<String, Double>) jsonObjects[2], (Map<String, String>) jsonObjects[3], (Double) jsonObjects[0]);
        }
        catch(Exception ex){
            String message = "There was an error parsing the XLS file "
                    + "(PreCleanButton parseCSV(File convertedFile, Map<String, Double> conversionMinimums, Map<String, String> conversionEquations, Double dilutionFactor)) \n";
            Message.Message.displayError("Parsing XLS File", message + ex.getMessage());
        }
        String outputCSV = CSV.buildPreCleanedCSV(parsedSamples);
        saveFile(outputCSV);
        xcelFile = null;
        convertedFile = null;
        parsedSamples = null;
    }
    
    /**
     * Brings up an open file dialog box for the user to select a CSV file to open.
     * @return File to use as input
     */
    private static File openFile(){
        FileChooser fileChooser = new FileChooser();
        String desktopDir = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop";
        fileChooser.setInitialDirectory(new File(desktopDir));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel", "*.xls"));
        return fileChooser.showOpenDialog(null);
        
    }
    /**
     * Brings up a save file dialog box for the user to select where to save the
     * newly created CSV.
     * @param outputData The String data to save to file
     */
    private static void saveFile(String outputData){
        FileChooser fileChooser = new FileChooser();
        String desktopDir = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop";
        fileChooser.setInitialDirectory(new File(desktopDir));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        DateFormat df = new SimpleDateFormat("yyyyMMddhhMMss");
        fileChooser.setInitialFileName("Sunshine PC " + df.format(new Date()));
        File saveFile = fileChooser.showSaveDialog(null);
        if(saveFile != null){
            CSV.writeToFile(saveFile, outputData);
        }
    }
    /**
     * Reads a CSV file and parses out a SampleAndCheck object
     * @param csvFile the input file
     * @param conversionMinimums the conversion minimums from the JSON config file
     * @param conversionEquations the conversion equations from the JSON config file
     * @param dilutionFactor the dilution factor from the JSON config file
     * @return SampleAndCheck object built from the CSV file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static SampleAndCheck parseCSV(File csvFile, Map<String, Double> conversionMinimums, Map<String, String> conversionEquations, Double dilutionFactor) throws FileNotFoundException, IOException{
        SunshineConversion conversion = new SunshineConversion(conversionMinimums, conversionEquations);
        SampleAndCheck samples = new SampleAndCheck();
        PreCleanIndexer preCleanIndex= new PreCleanIndexer();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        while((line = reader.readLine()) != null){
            line = line.trim();
            String[] pieces = line.split(",");
            /*====================
            Determine if the index has values yet
            ====================*/
            if(preCleanIndex.isComplete()){
                /*====================
                Build a sample and determine if it is a check or not
               ==================== */
                Sample tmp = new Sample(preCleanIndex, pieces, dilutionFactor, conversion);
                if(tmp.isCheck()){
                    /*====================
                    Add the check to the SampleAndCheck check list
                    ====================*/
                    samples.getChecks().add(Check.getCheckFromSample(tmp));
                }else{
                    /*====================
                    Add the sample to the SampleAndCheck sample list
                    ====================*/
                    samples.getSamples().add(tmp);
                }
            }else{
                /*====================
                Generates the index if it is not found
                ====================*/
                preCleanIndex.loadIndexes(pieces);
            }
        }     
        return samples;
    }
}
