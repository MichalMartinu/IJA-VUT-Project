package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating div of triangle
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class TriangleDiv extends TriangleObject {
    /**
     * Setting type of operation for triangle object
     */
    public TriangleDiv() {
        this.type = "Div";
    }
    /**
     * runs calculation div of triangle object
     */
    public void execute() {
        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            Double result;
            result = this.a / this.b / this.c;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }


}
