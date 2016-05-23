package Model;

/**
 *
 * @author Zach Larson
 */
public class Sample {
    private double b;
    private double ca;
    private double cu;
    private double fe;
    private double k;
    private double mg;
    private double mn;
    private double na;
    private double s;
    private double zn;
    private String containerID;

    /**
     * Generic constructor with no values
     */
    public Sample(){}
    
    /**
     * Constructor for creating samples when the Finalize button is pressed
     * @param index The indexer for the file
     * @param lineParts an array of strings
     */
    public Sample(FinalizeIndexer index, String[] lineParts){
        this.b = Double.parseDouble(replaceLetters(lineParts[index.getbColumn()]));
        this.ca = Double.parseDouble(replaceLetters(lineParts[index.getCaColumn()]));
        this.cu = Double.parseDouble(replaceLetters(lineParts[index.getCuColumn()]));
        this.fe = Double.parseDouble(replaceLetters(lineParts[index.getFeColumn()]));
        this.k = Double.parseDouble(replaceLetters(lineParts[index.getkColumn()]));
        this.mg = Double.parseDouble(replaceLetters(lineParts[index.getMgColumn()]));
        this.mn = Double.parseDouble(replaceLetters(lineParts[index.getMnColumn()]));
        this.na = Double.parseDouble(replaceLetters(lineParts[index.getNaColumn()]));
        this.s = Double.parseDouble(replaceLetters(lineParts[index.getsColumn()]));
        this.zn = Double.parseDouble(replaceLetters(lineParts[index.getZnColumn()]));
        this.containerID = removeQuotes(lineParts[index.getContainerIDColumn()]);
    }
    
    /**
     * Constructor for creating samples when the Pre-clean button is clicked
     * @param index The pre-clean indexer
     * @param lineParts an array of Strings
     * @param dilutionFactor the dilution factor (double)
     * @param converter  the conversion object
     */
    public Sample(PreCleanIndexer index, String[] lineParts, Double dilutionFactor, SunshineConversion converter){
        /*====================
        The value is set by using the SunshineConverter. The value input to the
        SunshineConverter is the test value * the dilution factor.
        ====================*/
        this.b = converter.convertB(Double.parseDouble(replaceLetters(lineParts[index.getbColumn()])) * dilutionFactor);
        this.ca = converter.convertCa(Double.parseDouble(replaceLetters(lineParts[index.getCaColumn()])) * dilutionFactor);
        this.cu = converter.convertCu(Double.parseDouble(replaceLetters(lineParts[index.getCuColumn()])) * dilutionFactor);
        this.fe = converter.convertFe(Double.parseDouble(replaceLetters(lineParts[index.getFeColumn()])) * dilutionFactor);
        this.k = converter.convertK(Double.parseDouble(replaceLetters(lineParts[index.getkColumn()])) * dilutionFactor);
        this.mg = converter.convertMg(Double.parseDouble(replaceLetters(lineParts[index.getMgColumn()])) * dilutionFactor);
        this.mn = converter.convertMn(Double.parseDouble(replaceLetters(lineParts[index.getMnColumn()])) * dilutionFactor);
        this.na = converter.convertNa(Double.parseDouble(replaceLetters(lineParts[index.getNaColumn()])) * dilutionFactor);
        this.s = converter.convertS(Double.parseDouble(replaceLetters(lineParts[index.getsColumn()])) * dilutionFactor);
        this.zn = converter.convertZn(Double.parseDouble(replaceLetters(lineParts[index.getZnColumn()])) * dilutionFactor);
        this.containerID = removeQuotes(lineParts[index.getContainerIDColumn()]);
    }
    
    /**
     * Replaces all letters, quotes, and apostrophes with nothing
     * @param toReplace the String to look at
     * @return a string with no letters
     */
    private String replaceLetters(String toReplace){
        String replacement =  toReplace.replaceAll("[A-Za-z\"\']", "");
        
        /*====================
        If the replacement contains a hyphen '-' it got converted to scientific
        notation when parsing the csv file, this will only happen when the number
        is exteremly close to Zero so it is safe to simple set the value to zero.
        ====================*/
        if(replacement.contains("-")){
            replacement = "0.0";
        }
        return replacement;
    }
    
    /**
     * Removes only quotes from a string
     * @param toReplace the string to look at
     * @return a string with no quotes
     */
    private String removeQuotes(String toReplace){
        return toReplace.replaceAll("[\"\']", "");
    }
    
    /**
     * Return the test value for Boron (B)
     * @return Double
     */
    public double getB() {
        return b;
    }

    /**
     * Set the test value for Boron (B)
     * @param b The value to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Return the test value for Calcium (Ca)
     * @return Double
     */
    public double getCa() {
        return ca;
    }

    /**
     * Set the test value for Calcium (Ca)
     * @param ca The value to set
     */
    public void setCa(double ca) {
        this.ca = ca;
    }

    /**
     * Return the test value for Copper (Cu)
     * @return Double
     */
    public double getCu() {
        return cu;
    }

    /**
     * Set the test value for Copper (Cu)
     * @param cu The value to set
     */
    public void setCu(double cu) {
        this.cu = cu;
    }

    /**
     * Return the test value for Iron (Fe)
     * @return Double
     */
    public double getFe() {
        return fe;
    }

    /**
     * Set the test value for Iron (Fe)
     * @param fe The value to set
     */
    public void setFe(double fe) {
        this.fe = fe;
    }

    /**
     * Return the test value for Potassium (K)
     * @return Double
     */
    public double getK() {
        return k;
    }

    /**
     * Set the test value for Potassium (K)
     * @param k The value to set
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * Return the test value for Magnesium (Mg)
     * @return Double
     */
    public double getMg() {
        return mg;
    }

    /**
     * Set the test value for Magnesium (Mg)
     * @param mg The value to set
     */
    public void setMg(double mg) {
        this.mg = mg;
    }

    /**
     * Return the test value for Manganese (Mn)
     * @return Double
     */
    public double getMn() {
        return mn;
    }

    /**
     * Set the test value for Manganese (Mn)
     * @param mn The value to set
     */
    public void setMn(double mn) {
        this.mn = mn;
    }

    /**
     * Return the test value for Sodium (Na)
     * @return Double
     */
    public double getNa() {
        return na;
    }

    /**
     * Set the test value for Sodium (Na)
     * @param na The value to set
     */
    public void setNa(double na) {
        this.na = na;
    }

    /**
     * Return the test value for Sulfur (S)
     * @return Double
     */
    public double getS() {
        return s;
    }

    /**
     * Set the test value for Sulfur (S)
     * @param s The value to set
     */
    public void setS(double s) {
        this.s = s;
    }
    
    /**
     * Return the test value for Zinc (Zn)
     * @return Double
     */
    public double getZn() {
        return zn;
    }

    /**
     * Set the test value for Zinc (Zn)
     * @param zn The value to set
     */
    public void setZn(double zn) {
        this.zn = zn;
    }

    /**
     * Return the container ID
     * @return String
     */
    public String getContainerID() {
        return containerID;
    }

    /**
     * Set the container ID for this sample
     * @param containerID The value to set
     */
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }
    
    /**
     * Determines if a sample is a check.
     * @return boolean
     */
    public boolean isCheck(){
        return containerID.equalsIgnoreCase("chk");
    }
    
    /**
     * Determines of a sample is an actual sample
     * @return boolean
     */
    public boolean isSample(){
        try{
            /*====================
            If the containerID can be converted to an Integer it is a real sample
            ====================*/
            int tmp = Integer.parseInt(containerID);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
    }
}
