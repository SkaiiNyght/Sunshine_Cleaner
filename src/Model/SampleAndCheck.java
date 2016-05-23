package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zach Larson
 */
public class SampleAndCheck {
    List<Sample> samples = new ArrayList();
    List<Check> checks = new ArrayList();
    
    /**
     * Returns a list of the samples for this SampleAndCheck
     * @return List(Sample)
     */
    public List<Sample> getSamples() {
        return samples;
    }
    
    /**
     * Returns a list of the checks for this SampleAndCheck
     * @return List(Sample)
     */
    public List<Check> getChecks() {
        return checks;
    }
}
