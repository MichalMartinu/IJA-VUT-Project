package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating sum of triangle
 */
public class TriangleSum extends TriangleObject{
    /**
     * Setting type of operation for triangle object
     */
    public TriangleSum() {
        this.type = "Sum";
    }
    /**
     * runs calculation sum of triangle object
     */
    public void execute() {
        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            Double result;
            result = this.a + this.b + this.c;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }


}
