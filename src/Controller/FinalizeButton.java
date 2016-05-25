package Controller;

import CSV.CSV;
import Config.PropertyWorker;
import Model.Check;
import Model.FinalizeIndexer;
import Model.MasterCheck;
import Model.Sample;
import Model.SampleAndCheck;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javafx.stage.FileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Zach Larson
 */
public class FinalizeButton {

    /**
     * Reads in a pre-cleaned CSV file and outputs a post-cleaned output file,
     * one with check adjustments.
     * @throws IOException
     * @throws ParseException 
     */
    public static void onClick() throws IOException, ParseException{
        PropertyWorker propWorker = null;
        try{
            propWorker = new PropertyWorker();
        }catch(IOException ioe){
            Message.Message.displayError("Closing Config File", "An Error occurred"
                    + " when attempting to close the configuration file.\n" + ioe.getMessage());
            System.exit(0);
        }
        File fileToOpen = openFile();
        
        SampleAndCheck samples = null;
        try {
            samples = parseCSV(fileToOpen);
        } catch (Exception ex) {
            String message = "There was an error parsing the input CSV, "
                    + "(FinalizeButton (paseCSV(File fileToOpen)) \n";
            Message.Message.displayError("Parsing input csv", message + ex.getMessage());
        }
        MasterCheck masterCheck = buildConversionFactors(samples, propWorker.getProperties());
        samples = alterSamples(samples, masterCheck);
        String outputCSV = CSV.buildFinalizedCSV(samples, Double.parseDouble(propWorker.getProperties().getProperty("sulfurToSulfate")));
        saveFile(outputCSV);
    }
    /**
     * Brings up an open file dialog box for the user to select a CSV file to open.
     * @return File to use as input
     */
    private static File openFile() {
        FileChooser fileChooser = new FileChooser();
        String desktopDir = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop";
        fileChooser.setInitialDirectory(new File(desktopDir));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv"));
        return fileChooser.showOpenDialog(null);
    }
    
    /**
     * Brings up a save file dialog box for the user to select where to save the
     * newly created CSV.
     * @param outputData The String data to save to file
     */
    private static void saveFile(String outputData) {
        FileChooser fileChooser = new FileChooser();
        String desktopDir = System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop";
        fileChooser.setInitialDirectory(new File(desktopDir));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        DateFormat df = new SimpleDateFormat("yyyyMMddhhMMss");
        fileChooser.setInitialFileName("Sunshine F " + df.format(new Date()));
        File saveFile = fileChooser.showSaveDialog(null);
        if (saveFile != null) {
            CSV.writeToFile(saveFile, outputData);
        }
    }
    
    /**
     * Reads in a pre-cleaned CSV file and breaks it down into a set of SampleAndCheck
     * @param csvToParse The input CSV
     * @return A list of samples that have been parsed out of the input file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static SampleAndCheck parseCSV(File csvToParse) throws FileNotFoundException, IOException {
        SampleAndCheck samples = new SampleAndCheck();
        BufferedReader reader = new BufferedReader(new FileReader(csvToParse));
        FinalizeIndexer indexer = new FinalizeIndexer();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            String[] pieces = line.split(",");
            if (indexer.isComplete()) {
                Sample tmp = new Sample(indexer, pieces);
                if (tmp.isCheck()) {
                    Check c = new Check(indexer, pieces);
                    samples.getChecks().add(c);
                } else {
                    samples.getSamples().add(tmp);
                }

            } else {
                indexer.loadIndexes(pieces);
            }
        }
        return samples;
    }

    /**
     * Cycles through all of the check samples adds up their totals and gets the
     * correction factor that will need to be applied to samples
     * @param samples a SampleAndCheck with check samples.
     * @param masterCheck the MasterCheck with newly calculated correction multipliers.
     * @return 
     */
    private static MasterCheck buildConversionFactors(SampleAndCheck samples, Properties properties) {
        MasterCheck masterCheck = new MasterCheck(properties);
        for (Check c : samples.getChecks()) {
            masterCheck.increaseTotal("B", c.getB());
            masterCheck.increaseTotal("Ca", c.getCa());
            masterCheck.increaseTotal("Cu", c.getCu());
            masterCheck.increaseTotal("Fe", c.getFe());
            masterCheck.increaseTotal("K", c.getK());
            masterCheck.increaseTotal("Mg", c.getMg());
            masterCheck.increaseTotal("Mn", c.getMn());
            masterCheck.increaseTotal("Na", c.getNa());
            masterCheck.increaseTotal("S", c.getS());
            masterCheck.increaseTotal("Zn", c.getZn());
            masterCheck.increaseSampleCount();
        }
        masterCheck.doConversion();
        return masterCheck;
    }
    
    /**
     * Applies the correction factor to all of the actual samples and check samples
     * @param samples the SampleAndCheck that has samples to be altered
     * @param masterCheck the MasterCheck with the correction multipliers
     * @return an updated SampleAndCheck
     */
    private static SampleAndCheck alterSamples(SampleAndCheck samples, MasterCheck masterCheck) {
        /*====================
        Do the samples first, making sure that only the samples are being altered
        and ignore any standard, quality checks, and blanks
        ====================*/
        for (Sample sample : samples.getSamples()) {
            if (sample.isSample()) {
                sample.setB(sample.getB() * masterCheck.getbMultiplier());
                sample.setCa(sample.getCa() * masterCheck.getCaMultiplier());
                sample.setCu(sample.getCu() * masterCheck.getCuMultipler());
                sample.setFe(sample.getFe() * masterCheck.getFeMultiplier());
                sample.setK(sample.getK() * masterCheck.getkMultiplier());
                sample.setMg(sample.getMg() * masterCheck.getMgMultiplier());
                sample.setMn(sample.getMn() * masterCheck.getMnMultiplier());
                sample.setNa(sample.getNa() * masterCheck.getNaMultiplier());
                sample.setS(sample.getS() * masterCheck.getsMultiplier());
                sample.setZn(sample.getZn() * masterCheck.getZnMultiplier());
            }

        }
        /*====================
        Do the check samples second, since there will be nothing but checks in
        this list it is not necessary to check to see if it is a check.
        ====================*/
        for (Sample sample : samples.getChecks()) {
            sample.setB(sample.getB() * masterCheck.getbMultiplier());
            sample.setCa(sample.getCa() * masterCheck.getCaMultiplier());
            sample.setCu(sample.getCu() * masterCheck.getCuMultipler());
            sample.setFe(sample.getFe() * masterCheck.getFeMultiplier());
            sample.setK(sample.getK() * masterCheck.getkMultiplier());
            sample.setMg(sample.getMg() * masterCheck.getMgMultiplier());
            sample.setMn(sample.getMn() * masterCheck.getMnMultiplier());
            sample.setNa(sample.getNa() * masterCheck.getNaMultiplier());
            sample.setS(sample.getS() * masterCheck.getsMultiplier());
            sample.setZn(sample.getZn() * masterCheck.getZnMultiplier());
        }
        return samples;
    }
}
