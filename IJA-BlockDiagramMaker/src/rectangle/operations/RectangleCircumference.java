package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating circumference of rectangle
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class RectangleCircumference extends RectangleObject {
    /**
     * Setting type of operation for triangle object
     */
    public RectangleCircumference() {
        this.type = "Circumference";
    }

    /**
     * runs calculation circumference of triangle object
     */
    public void execute()
    {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = 2*(this.a + this.b);
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";

        }
    }

}
