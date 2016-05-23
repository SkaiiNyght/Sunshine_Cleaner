package Model;

import java.util.HashMap;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

/**
 *
 * @author Zach Larson
 */
public class SunshineConversion {

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
    private final String bConversion;
    private final String caConversion;
    private final String cuConversion;
    private final String feConversion;
    private final String kConversion;
    private final String mgConversion;
    private final String mnConversion;
    private final String naConversion;
    private final String sConversion;
    private final String znConversion;
    private final Map<String, Double> conversionMinimums;

    /**
     * Constructor for the SunshineConversion
     *
     * @param conversionMinimums The minimums to apply any conversion on
     * @param conversionEquations The equations for the conversions
     */
    public SunshineConversion(Map<String, Double> conversionMinimums, Map<String, String> conversionEquations) {
        this.conversionMinimums = conversionMinimums;
        bConversion = conversionEquations.get("B");
        caConversion = conversionEquations.get("Ca");
        cuConversion = conversionEquations.get("Cu");
        feConversion = conversionEquations.get("Fe");
        kConversion = conversionEquations.get("K");
        mgConversion = conversionEquations.get("Mg");
        mnConversion = conversionEquations.get("Mn");
        naConversion = conversionEquations.get("Na");
        sConversion = conversionEquations.get("S");
        znConversion = conversionEquations.get("Zn");
    }

    /**
     * Effectively sets the VALUE part of the equation
     *
     * @param value the value you wish to insert into the equation
     * @return a map of the mapped value.
     */
    private Map<String, Object> getVariableMap(Double value) {
        Map<String, Object> map = new HashMap();
        map.put("VALUE", value);
        return map;
    }

    /**
     * Calculates the value to be sent back after the conversion is completed
     *
     * @param value the value to do the conversion on
     * @param equation the equation to use in the conversion
     * @param testName the name of the element (testName)
     * @return a converted Double
     */
    private double calculate(Double value, String equation, String testName) {
        try {

            /*====================
            Determine if the conversion needs to be done based on the minimum
            converion value.
            ====================*/
            if (value <= conversionMinimums.get(testName)) {
                return value;
            }
            return (Double) engine.eval(equation, new SimpleBindings(getVariableMap(value)));
        } catch (Exception ex) {
            String message = "A problem occured during the value conversion "
                    + "(SunshineConversion (calculate(Double value, String equation, String testName)) \n";
            Message.Message.displayError("Problems during value conversion", message + ex.getMessage());
            return -1.0;
        }

    }

    /**
     * Returns the converted value for Boron (B)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertB(Double value) {
        return calculate(value, bConversion, "B");
    }

    /**
     * Returns the converted value for Calcium (Ca)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertCa(Double value) {
        return calculate(value, caConversion, "Ca");
    }

    /**
     * Returns the converted value for Copper (Cu)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertCu(Double value) {
        return calculate(value, cuConversion, "Cu");
    }

    /**
     * Returns the converted value for Iron (Fe)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertFe(Double value) {
        return calculate(value, feConversion, "Fe");
    }

    /**
     * Returns the converted value for Potassium (K)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertK(Double value) {
        return calculate(value, kConversion, "K");
    }

    /**
     * Returns the converted value for Magnesium (Mg)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertMg(Double value) {
        return calculate(value, mgConversion, "Mg");
    }

    /**
     * Returns the converted value for Manganese (Mn)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertMn(Double value) {
        return calculate(value, mnConversion, "Mn");
    }

    /**
     * Returns the converted value for Sodium (Na)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertNa(Double value) {
        return calculate(value, naConversion, "Na");
    }

    /**
     * Returns the converted value for Sulfur (S)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertS(Double value) {
        return calculate(value, sConversion, "S");
    }

    /**
     * Returns the converted value for Zinc (Zn)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertZn(Double value) {
        return calculate(value, znConversion, "Zn");
    }

}
