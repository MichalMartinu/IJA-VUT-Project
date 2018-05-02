package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Calculating area of rectangle
 */
public class RectangleArea extends RectangleObject {
    /**
     * Setting type of operation for rectangle object
     */
    public RectangleArea() {
        this.type = "Area";
    }

    /**
     * runs calculation area of rectangle object
     */
    public void execute()
    {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = this.a * this.b;
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";
        }
    }

}