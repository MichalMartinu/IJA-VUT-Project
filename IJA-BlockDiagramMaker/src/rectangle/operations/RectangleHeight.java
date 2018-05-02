package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating height of rectangle
 */
public class RectangleHeight extends RectangleObject{
    /**
     * Setting type of operation for rectangle object
     */
    public RectangleHeight() {
        this.type = "Height";
    }

    /**
     * runs calculation height of rectangle object
     */
    public void execute()
    {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = this.b;
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";
        }


    }


}
