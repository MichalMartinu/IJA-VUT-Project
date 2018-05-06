package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating sum of rectangle
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class SquareSum extends SquareObject{
    /**
     * Setting type of operation for square object
     */
    public SquareSum() {
        this.type = "Sum";
    }
    /**
     * runs calculation sum of square object
     */
    public void execute() {
        if (this.a > 0)
        {
            Double result;
            result = Math.round(this.a * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }
}
