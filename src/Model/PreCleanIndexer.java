package Model;

/**
 *
 * @author Zach Larson
 */
public class PreCleanIndexer {

    private int containerIDColumn = 1;
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
     * Loads the indexes in based on an array of Strings
     *
     * @param lineParts
     */
    public void loadIndexes(String[] lineParts) {
        for (int i = 0; i < lineParts.length; i++) {
            if (lineParts[i] != null && !lineParts[i].isEmpty()) {
                switch (lineParts[i].toLowerCase()) {
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
    }

    /**
     * Determines if there are values for each index
     *
     * @return boolean
     */
    public boolean isComplete() {
        return bColumn != -1
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
     * Return the index of the container ID column
     *
     * @return Integer
     */
    public int getContainerIDColumn() {
        return containerIDColumn;
    }

    /**
     * Return the index of the Boron (B) column
     *
     * @return Integer
     */
    public int getbColumn() {
        return bColumn;
    }

    /**
     * Return the index of the Calcium (Ca) column
     *
     * @return Integer
     */
    public int getCaColumn() {
        return caColumn;
    }

    /**
     * Return the index of the Copper (Cu) column
     *
     * @return Integer
     */
    public int getCuColumn() {
        return cuColumn;
    }

    /**
     * Return the index of the Iron (Fe) column
     *
     * @return Integer
     */
    public int getFeColumn() {
        return feColumn;
    }

    /**
     * Return the index of the Potassium (K) column
     *
     * @return Integer
     */
    public int getkColumn() {
        return kColumn;
    }

    /**
     * Return the index of the Magnesium (Mg) column
     *
     * @return Integer
     */
    public int getMgColumn() {
        return mgColumn;
    }

    /**
     * Return the index of the Manganese (Mn) column
     *
     * @return Integer
     */
    public int getMnColumn() {
        return mnColumn;
    }

    /**
     * Return the index of the Sodium (Na) column
     *
     * @return Integer
     */
    public int getNaColumn() {
        return naColumn;
    }

    /**
     * Return the index of the Sulfur (S) column
     *
     * @return Integer
     */
    public int getsColumn() {
        return sColumn;
    }

    /**
     * Return the index of the Zinc (Zn) column
     *
     * @return Integer
     */
    public int getZnColumn() {
        return znColumn;
    }
}
