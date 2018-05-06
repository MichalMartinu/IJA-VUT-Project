package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating sum of rectangle
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class RectangleSum extends RectangleObject{
    /**
     * Setting type of operation for rectangle object
     */
    public RectangleSum() {
        this.type = "Sum";
    }

    /**
     * runs calculation sum of rectangle object
     */
    public void execute() {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = this.a + this.b;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }


}
