package CSV;

import Message.Message;
import Model.SampleAndCheck;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 *
 * @author Zach Larson
 */
public class CSV {
    /**
     * Builds a csv string from the input
     * @param samples
     * @return CSV String
     */
    public static String buildPreCleanedCSV(SampleAndCheck samples){
        StringBuilder csv = new StringBuilder();
        final String NL = "\r\n";
        /*====================
        Header Columns
        ====================*/
        csv.append("ContainerID,Analyte,B,Ca,Cu,Fe,K,Mg,Mn,Na,S,Zn").append(NL);
        
        /*====================
        Do everything but the checks first
        ====================*/
        samples.getSamples().forEach(sample ->{
            csv.append(sample.getContainerID()).append(",");
            csv.append("Sunshine").append(",");
            csv.append(sample.getB()).append(",");
            csv.append(sample.getCa()).append(",");
            csv.append(sample.getCu()).append(",");
            csv.append(sample.getFe()).append(",");
            csv.append(sample.getK()).append(",");
            csv.append(sample.getMg()).append(",");
            csv.append(sample.getMn()).append(",");
            csv.append(sample.getNa()).append(",");
            csv.append(sample.getS()).append(",");
            csv.append(sample.getZn()).append(NL);
        });
        
        /*====================
        Do the checks second
        ====================*/
        samples.getChecks().forEach(sample ->{
            csv.append(sample.getContainerID()).append(",");
            csv.append("Sunshine").append(",");
            csv.append(sample.getB()).append(",");
            csv.append(sample.getCa()).append(",");
            csv.append(sample.getCu()).append(",");
            csv.append(sample.getFe()).append(",");
            csv.append(sample.getK()).append(",");
            csv.append(sample.getMg()).append(",");
            csv.append(sample.getMn()).append(",");
            csv.append(sample.getNa()).append(",");
            csv.append(sample.getS()).append(",");
            csv.append(sample.getZn()).append(NL);
        });
        return csv.toString();
    }
    /**
     * Builds a CSV string from the input
     * @param samples
     * @param StoSulfateFactor
     * @return CSV String
     */
    public static String buildFinalizedCSV(SampleAndCheck samples, double StoSulfateFactor){
        StringBuilder csv = new StringBuilder();
        final String NL = "\r\n";
        
        /*====================
        Header Columns
        ====================*/
        csv.append("ContainerID,Analyte,B,Ca,Cu,Fe,K,Mg,Mn,Na,S,Sulfate S,Zn").append(NL);
        
        /*====================
        Do everything but the checks first
        ====================*/
        samples.getSamples().forEach(sample ->{
            csv.append(sample.getContainerID()).append(",");
            csv.append("Sunshine").append(",");
            csv.append(sample.getB()).append(",");
            csv.append(sample.getCa()).append(",");
            csv.append(sample.getCu()).append(",");
            csv.append(sample.getFe()).append(",");
            csv.append(sample.getK()).append(",");
            csv.append(sample.getMg()).append(",");
            csv.append(sample.getMn()).append(",");
            csv.append(sample.getNa()).append(",");
            csv.append(sample.getS()).append(",");
            csv.append(sample.getS() * StoSulfateFactor).append(",");
            csv.append(sample.getZn()).append(NL);
        });
        
        /*====================
        Do the checks second
        ====================*/
        samples.getChecks().forEach(sample ->{
            csv.append(sample.getContainerID()).append(",");
            csv.append("Sunshine").append(",");
            csv.append(sample.getB()).append(",");
            csv.append(sample.getCa()).append(",");
            csv.append(sample.getCu()).append(",");
            csv.append(sample.getFe()).append(",");
            csv.append(sample.getK()).append(",");
            csv.append(sample.getMg()).append(",");
            csv.append(sample.getMn()).append(",");
            csv.append(sample.getNa()).append(",");
            csv.append(sample.getS()).append(",");
            csv.append(sample.getS() * StoSulfateFactor).append(",");
            csv.append(sample.getZn()).append(NL);
        });
        return csv.toString();
    }
    
    /**
     * Writes the content to the specified file
     * @param file
     * @param content 
     */
    public static void writeToFile(File file, String content){
         Path path = file.toPath();
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        } catch (Exception ex) {
            String message = "There was an error writing to file. (CSV.java writeToFile(File file, String content)) \n";
            Message.displayError("Write To File", message + ex.getMessage());
        }
    }
}
