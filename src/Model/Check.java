package Model;

/**
 *
 * @author Zach Larson
 */
public class Check extends Sample{
    /**
     * Generic constructor, generates a Check with no values
     */
    public Check(){
        super();
    }
    
    /**
     * Generates a Check from an indexer and an array of Strings
     * @param index The index to reference
     * @param lineParts array of Strings
     */
    public Check(FinalizeIndexer index, String[] lineParts){
        super(index, lineParts);
    }
    /**
     * Builds a check from a pre-existing sample
     * @param sample the sample to convert from
     * @return a Check sample
     */
    public static Check getCheckFromSample(Sample sample){
        Check tmp = new Check();
        tmp.setB(sample.getB());
        tmp.setCa(sample.getCa());
        tmp.setContainerID(sample.getContainerID());
        tmp.setCu(sample.getCu());
        tmp.setFe(sample.getFe());
        tmp.setK(sample.getK());
        tmp.setMg(sample.getMg());
        tmp.setMn(sample.getMn());
        tmp.setNa(sample.getNa());
        tmp.setS(sample.getS());
        tmp.setZn(sample.getZn());
        return tmp;
    }
}
