package Model;

import java.util.Properties;

/**
 *
 * @author Zach Larson
 */
public class MasterCheck {

    /*====================
    Master Check Vales (Used to determine the correction multiplier)
    ====================*/
    private double bMaster;
    private double caMaster;
    private double cuMaster;
    private double feMaster;
    private double kMaster;
    private double mgMaster;
    private double mnMaster;
    private double naMaster;
    private double sMaster;
    private double znMaster;

    
    /*====================
    The number of checks read so far
    ====================*/
    private int sampleCount = 0;
    
    
    /*====================
    Total Values, the aggregate total of all check samples for 
    ====================*/
    private double bTotal;
    private double caTotal;
    private double cuTotal;
    private double feTotal;
    private double kTotal;
    private double mgTotal;
    private double mnTotal;
    private double naTotal;
    private double sTotal;
    private double znTotal;
    
    /*====================
    Multiplier Values, the correction multiplier that will be applied to samples
    ====================*/
    private double bMultiplier;
    private double caMultiplier;
    private double cuMultiplier;
    private double feMultiplier;
    private double kMultiplier;
    private double mgMultiplier;
    private double mnMultiplier;
    private double naMultiplier;
    private double sMultiplier;
    private double znMultiplier;

    
    public MasterCheck(Properties properties){
        this.bMaster = Double.parseDouble(properties.getProperty("masterCheckB"));
        this.caMaster = Double.parseDouble(properties.getProperty("masterCheckCa"));
        this.cuMaster = Double.parseDouble(properties.getProperty("masterCheckCu"));
        this.feMaster = Double.parseDouble(properties.getProperty("masterCheckFe"));
        this.kMaster = Double.parseDouble(properties.getProperty("masterCheckK"));
        this.mgMaster = Double.parseDouble(properties.getProperty("masterCheckMg"));
        this.mnMaster = Double.parseDouble(properties.getProperty("masterCheckMn"));
        this.naMaster = Double.parseDouble(properties.getProperty("masterCheckNa"));
        this.sMaster = Double.parseDouble(properties.getProperty("masterCheckS"));
        this.znMaster = Double.parseDouble(properties.getProperty("masterCheckZn"));
    }
    
    /**
     * Calculates the multiplier needed for each element based upon the master
     * value divided by the average.
     */
    public void doConversion() {
        double average;
        /*====================
        Boron (B)
        ====================*/
        average = bTotal / sampleCount;
        bMultiplier = bMaster / average;
        
        
        /*====================
        Calcium (Ca)
        ====================*/
        average = caTotal / sampleCount;
        caMultiplier = caMaster / average;
        
        
        /*====================
        Copper (Cu)
        ====================*/
        average = cuTotal / sampleCount;
        cuMultiplier = cuMaster / average;
        
        
        /*====================
        Iron (Fe)
        ====================*/
        average = feTotal / sampleCount;
        feMultiplier = feMaster / average;
        
        
        /*====================
        Potassium (K)
        ====================*/
        average = kTotal / sampleCount;
        kMultiplier = kMaster / average;
        
        
        /*====================
        Magnesium (Mg)
        ====================*/
        average = mgTotal / sampleCount;
        mgMultiplier = mgMaster / average;
        
        
        /*====================
        Manganese (Mn)
        ====================*/
        average = mnTotal / sampleCount;
        mnMultiplier = mnMaster / average;
        
        
        /*====================
        Sodium (Na)
        ====================*/
        average = naTotal / sampleCount;
        naMultiplier = naMaster / average;
        
        
        /*====================
        Sulfur (S)
        ====================*/
        average = sTotal / sampleCount;
        sMultiplier = sMaster / average;
        
        
        /*====================
        Zinc (Zn)
        ====================*/
        average = znTotal / sampleCount;
        znMultiplier = znMaster / average;

    }
    
    /**
     * Returns the number of samples that have been added to the master check
     * so far.
     * @return Integer
     */
    public int getSampleCount() {
        return sampleCount;
    }

    /**
     * Increases the sample count by one.
     */
    public void increaseSampleCount(){
        this.sampleCount++;
    }
    /**
     * 
     * @return 
     */
    public double getbTotal() {
        return bTotal;
    }
    public void increaseTotal(String testName, double value){
        switch(testName){
            case "B":
                this.bTotal += value;
                break;
            case "Ca":
                this.caTotal += value;
                break;
            case "Cu":
                this.caTotal += value;
                break;
            case "Fe":
                this.feTotal += value;
                break;
            case "K":
                this.kTotal += value;
                break;
            case "Mg":
                this.mgTotal += value;
                break;
            case "Mn":
                this.mnTotal += value;
                break;
            case "Na":
                this.naTotal += value;
                break;
            case "S":
                this.sTotal += value;
                break;
            case "Zn":
                this.znTotal += value;
                break;
            default:
                break;
        }
    }
    
    /**
     * Returns the correction multiplier for Boron (B)
     * @return Double
     */
    public double getbMultiplier() {
        return bMultiplier;
    }

    /**
     * Returns the correction multiplier for Calcium (Ca)
     * @return Double
     */
    public double getCaMultiplier() {
        return caMultiplier;
    }
    
    /**
     * Returns the correction multiplier for Copper (Cu)
     * @return Double
     */
    public double getCuMultipler() {
        return cuMultiplier;
    }

    /**
     * Returns the correction multiplier for Iron (Fe)
     * @return Double
     */
    public double getFeMultiplier() {
        return feMultiplier;
    }

    /**
     * Returns the correction multiplier for Potassium (K)
     * @return Double
     */
    public double getkMultiplier() {
        return kMultiplier;
    }
    
    /**
     * Returns the correction multiplier for Magnesium (Mg)
     * @return Double
     */
    public double getMgMultiplier() {
        return mgMultiplier;
    }

    /**
     * Returns the correction multiplier for Manganese (Mn)
     * @return Double
     */
    public double getMnMultiplier() {
        return mnMultiplier;
    }

    /**
     * Returns the correction multiplier for Sodium (Na)
     * @return Double
     */
    public double getNaMultiplier() {
        return naMultiplier;
    }

    /**
     * Returns the correction multiplier for Sulfur (S)
     * @return Double
     */
    public double getsMultiplier() {
        return sMultiplier;
    }

    /**
     * Returns the correction multiplier for Zinc (Zn)
     * @return Double
     */
    public double getZnMultiplier() {
        return znMultiplier;
    }

    /**
     * Sets the master value for Boron (B)
     * @param bMaster The value to set
     */
    public void setbMaster(double bMaster) {
        this.bMaster = bMaster;
    }

    /**
     * Sets the master value for Calcium (Ca)
     * @param caMaster The value to set
     */
    public void setCaMaster(double caMaster) {
        this.caMaster = caMaster;
    }

    /**
     * Sets the master value for Copper (Cu)
     * @param cuMaster The value to set
     */
    public void setCuMaster(double cuMaster) {
        this.cuMaster = cuMaster;
    }

    /**
     * Sets the master value for Iron (Fe)
     * @param feMaster The value to set
     */
    public void setFeMaster(double feMaster) {
        this.feMaster = feMaster;
    }

    /**
     * Sets the master value for Potassium (K)
     * @param kMaster The value to set
     */
    public void setkMaster(double kMaster) {
        this.kMaster = kMaster;
    }

    /**
     * Sets the master value for Magnesium (Mg)
     * @param mgMaster The value to set
     */
    public void setMgMaster(double mgMaster) {
        this.mgMaster = mgMaster;
    }

    /**
     * Sets the master value for Manganese (Mn)
     * @param mnMaster The value to set
     */
    public void setMnMaster(double mnMaster) {
        this.mnMaster = mnMaster;
    }

    /**
     * Sets the master value for Sodium (Na)
     * @param naMaster The value to set
     */
    public void setNaMaster(double naMaster) {
        this.naMaster = naMaster;
    }

    /**
     * Sets the master value for Sulfur (S)
     * @param sMaster The value to set
     */
    public void setsMaster(double sMaster) {
        this.sMaster = sMaster;
    }

    /**
     * Sets the master value for Zinc (Zn)
     * @param znMaster The value to set
     */
    public void setZnMaster(double znMaster) {
        this.znMaster = znMaster;
    }

}
