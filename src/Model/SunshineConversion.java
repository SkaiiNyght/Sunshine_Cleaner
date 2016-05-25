package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

/**
 *
 * @author Zach Larson
 */
public class SunshineConversion {

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
    private final Properties properties;

    /**
     * Constructor for the SunshineConversion
     *
     * @param properties The properties from the configuration file
     */
    public SunshineConversion(Properties properties) {
        this.properties = properties;
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
    private double calculate(Double value, String testName) {
        try {
            String minimum = "conversionMinimum" + testName;
            String equation = "conversionEquation" + testName;
            /*====================
            Determine if the conversion needs to be done based on the minimum
            converion value.
            ====================*/
            if (value <= Double.parseDouble(properties.getProperty(minimum))) {
                return value;
            }
            return (Double) engine.eval(properties.getProperty(equation), new SimpleBindings(getVariableMap(value)));
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
        return calculate(value, "B");
    }

    /**
     * Returns the converted value for Calcium (Ca)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertCa(Double value) {
        return calculate(value, "Ca");
    }

    /**
     * Returns the converted value for Copper (Cu)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertCu(Double value) {
        return calculate(value, "Cu");
    }

    /**
     * Returns the converted value for Iron (Fe)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertFe(Double value) {
        return calculate(value, "Fe");
    }

    /**
     * Returns the converted value for Potassium (K)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertK(Double value) {
        return calculate(value, "K");
    }

    /**
     * Returns the converted value for Magnesium (Mg)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertMg(Double value) {
        return calculate(value, "Mg");
    }

    /**
     * Returns the converted value for Manganese (Mn)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertMn(Double value) {
        return calculate(value, "Mn");
    }

    /**
     * Returns the converted value for Sodium (Na)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertNa(Double value) {
        return calculate(value, "Na");
    }

    /**
     * Returns the converted value for Sulfur (S)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertS(Double value) {
        return calculate(value, "S");
    }

    /**
     * Returns the converted value for Zinc (Zn)
     *
     * @param value the value to convert
     * @return Double
     */
    public Double convertZn(Double value) {
        return calculate(value, "Zn");
    }

}
