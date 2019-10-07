package cz.upce.fei.inptp.zz.entity;
import java.util.NoSuchElementException;
/**
 *
 * @author Roman
 */
public class DistanceMatrix {

    private String[] locations;
    private double[][] distances;

    public DistanceMatrix(String[] locations, double[][] distances) {
        this.locations = locations;
        this.distances = distances;
    }
    
    public double get(String from, String to) throws NoSuchElementException{
        int fromIndex = getLocationIndex(from);
        int toIndex = getLocationIndex(to);
        if (fromIndex < 0 || toIndex < 0) 
            throw new NoSuchElementException("Inserted location was not found.");
        return distances[fromIndex][toIndex];
    }

    private int getLocationIndex(String value) {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
    
}
