package triangle.operations;

import triangle.TriangleObject;


import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating area of triangle
 */
public class TriangleArea extends TriangleObject{
    /**
     * Setting type of operation for triangle object
     */
    public TriangleArea() {
        this.type = "Area";
    }

    /**
     * runs calculation area of triangle object
     */
    public void execute()
    {

        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            Double result;
            Double s = (this.a+this.b+this.c)/2;

            result = Math.sqrt(s*(s-this.a)*(s-this.b)*(s-this.c));
            result = Math.round(result * 1000000d)/1000000d;

            this.state = "calculated";
            this.outputResult = result;
        }
    }


}
