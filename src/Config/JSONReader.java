package Config;

import Message.Message;
import Model.MasterCheck;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Zach Larson
 */
public class JSONReader {

    public static Object[] getJSONObjects() {
        Object[] items = new Object[4];
        try {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(new FileReader("./src/config.txt"));

            /*====================
            Dilution Factor is index 0
            ====================*/
            items[0] = getDilutionFactor(root);

            /*====================
            Master Check is index 1
            ====================*/
            items[1] = loadMasterCheck(root);

            /*====================
            Conversion minimums is index 2
            ====================*/
            items[2] = loadConversionMinimums(root);

            /*====================
            Conversion Equations are index 3
            ====================*/
            items[3] = loadConversionEquations(root);
        } catch (Exception ex) {
            String message = "There was an error reading the config.txt file "
                    + "(JSONReader getJSONObjects()) \n";
            Message.displayError("Unable To Read Config File", message + ex.getMessage());
        }
        return items;
    }

    /**
     * Reads from the JSON configuration file and returns the dilution factor.
     *
     * @return DilutionFactor (Double)
     */
    private static double getDilutionFactor(JSONObject root) {
        double dilutionFactor = Double.parseDouble(String.valueOf(root.get("Dilution")));
        return dilutionFactor;
    }

    /**
     * Reads from the JSON configuration file and returns a MasterCheck with all
     * the master values loaded in.
     *
     * @return MasterCheck
     */
    private static MasterCheck loadMasterCheck(JSONObject root) {
        MasterCheck master = new MasterCheck();
        JSONObject checks = (JSONObject) root.get("CheckValues");
        master.setbMaster(Double.parseDouble(String.valueOf(checks.get("B"))));
        master.setCaMaster(Double.parseDouble(String.valueOf(checks.get("Ca"))));
        master.setCuMaster(Double.parseDouble(String.valueOf(checks.get("Cu"))));
        master.setFeMaster(Double.parseDouble(String.valueOf(checks.get("Fe"))));
        master.setkMaster(Double.parseDouble(String.valueOf(checks.get("K"))));
        master.setMgMaster(Double.parseDouble(String.valueOf(checks.get("Mg"))));
        master.setMnMaster(Double.parseDouble(String.valueOf(checks.get("Mn"))));
        master.setNaMaster(Double.parseDouble(String.valueOf(checks.get("Na"))));
        master.setsMaster(Double.parseDouble(String.valueOf(checks.get("S"))));
        master.setZnMaster(Double.parseDouble(String.valueOf(checks.get("Zn"))));

        return master;
    }

    /**
     * Reads from the JSON configuration file and returns a HashMap of the
     * minimum values.
     *
     * @return HashMap Key: Element Name (String), Value: Minimum (Double)
     */
    private static Map<String, Double> loadConversionMinimums(JSONObject root) {
        /*========================
        Key = Element, Value = Minimum Value To Do Conversion with
         ========================*/
        Map<String, Double> minimumMap = new HashMap();
        JSONObject minimums = (JSONObject) root.get("ConversionMinimumsAfterDilutionFactor");
        Set<String> keySet = minimums.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            minimumMap.put(key, Double.parseDouble(String.valueOf(minimums.get(key))));
        }

        return minimumMap;
    }

    /**
     * Reads from the JSON configuration file and returns a HashMap of the
     * equations.
     *
     * @return HashMap Key: Element Name (String), Value: Equation (String)
     */
    private static Map<String, String> loadConversionEquations(JSONObject root) {
        /*========================
        Key = Element, Value = Equation
         ========================*/
        Map<String, String> conversionMap = new HashMap();
        JSONObject factors = (JSONObject) root.get("ConversionFactors");
        Set<String> keySet = factors.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            conversionMap.put(key, (String) factors.get(key));
        }
        return conversionMap;
    }
}
