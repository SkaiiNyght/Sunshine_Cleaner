package Model;

/**
 *
 * @author Zach larson
 */
public class FinalizeIndexer {

    private int containerIDColumn = -1;
    private int bColumn = -1;
    private int caColumn = -1;
    private int cuColumn = -1;
    private int feColumn = -1;
    private int kColumn = -1;
    private int mgColumn = -1;
    private int mnColumn = -1;
    private int naColumn = -1;
    private int sColumn = -1;
    private int znColumn = -1;

    /**
     * Determines whether all the required columns have been found in the CSV
     * file.
     * @return boolean
     */
    public boolean isComplete() {
        return containerIDColumn != -1
                && bColumn != -1
                && caColumn != -1
                && cuColumn != -1
                && feColumn != -1
                && kColumn != -1
                && mgColumn != -1
                && mnColumn != -1
                && naColumn != -1
                && sColumn != -1
                && znColumn != -1;
    }

    /**
     * Initializes the index values for the indexer based on an array of Strings
     * which are simply a line in the CSV split by a comma ','
     * @param lineParts A line of the CSV split by a comma ','
     */
    public void loadIndexes(String[] lineParts) {
        for (int i = 0; i < lineParts.length; i++) {
            switch (lineParts[i].toLowerCase()) {
                case "containerid":
                    containerIDColumn = i;
                    break;
                case "b":
                    bColumn = i;
                    break;
                case "ca":
                    caColumn = i;
                    break;
                case "cu":
                    cuColumn = i;
                    break;
                case "fe":
                    feColumn = i;
                    break;
                case "k":
                    kColumn = i;
                    break;
                case "mg":
                    mgColumn = i;
                    break;
                case "mn":
                    mnColumn = i;
                    break;
                case "na":
                    naColumn = i;
                    break;
                case "s":
                    sColumn = i;
                    break;
                case "zn":
                    znColumn = i;
                    break;
            }
        }
    }
    
    /**
     * Returns the index of the containerID column
     * @return Integer
     */
    public int getContainerIDColumn() {
        return containerIDColumn;
    }
    
    /**
     * Returns the index of the Boron column
     * @return Integer
     */
    public int getbColumn() {
        return bColumn;
    }
    
    /**
     * Returns the index of the Calcium column
     * @return Integer
     */
    public int getCaColumn() {
        return caColumn;
    }
    
    /**
     * Returns the index of the Copper column
     * @return Integer
     */
    public int getCuColumn() {
        return cuColumn;
    }
    
    /**
     * Returns the index of the Iron column
     * @return Integer
     */
    public int getFeColumn() {
        return feColumn;
    }
    
    /**
     * Returns the index of the Potassium column
     * @return Integer
     */
    public int getkColumn() {
        return kColumn;
    }
    
    /**
     * Returns the index of the Magnesium column
     * @return Integer
     */
    public int getMgColumn() {
        return mgColumn;
    }
    
    /**
     * Returns the index of the Manganese column
     * @return Integer
     */
    public int getMnColumn() {
        return mnColumn;
    }
    
    /**
     * Returns the index of the Sodium column
     * @return Integer
     */
    public int getNaColumn() {
        return naColumn;
    }
    
    /**
     * Returns the index of the Sulfur column
     * @return Integer
     */
    public int getsColumn() {
        return sColumn;
    }
    
    /**
     * Returns the index of the Zinc column
     * @return Integer
     */
    public int getZnColumn() {
        return znColumn;
    }
}
