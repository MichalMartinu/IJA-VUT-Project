package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Calculating height of triangle
 */
public class TriangleHeight extends TriangleObject {
    private String side = "a";
    /**
     * Setting type of operation for triangle object
     */
    public TriangleHeight() {
        this.type = "Height";
    }

    /**
     * runs calculation height of triangle object
     */
    public void execute()
    {

        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            double angle;
            Double result = 0.0;

            if(this.side.equals("a"))
            {
                angle = LawOfCosine(this.b, this.a, this.c); //Delta
                result = Math.sin(angle)*this.c;
            }
            else if(this.side.equals("b"))
            {
                angle = LawOfCosine(this.c, this.a, this.b); //Beta
                result = Math.sin(angle)*this.a;
            }
            else if(this.side.equals("c"))
            {
                angle = LawOfCosine(this.a, this.b, this.c); //Alpha
                result = Math.sin(angle)*this.b;
            }

            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }
    }

    /**
     * helper function for cosine
     * @param a side a of triangle
     * @param b side b of triangle
     * @param c side c of triangle
     * @return angle of alpha a
     */
    private double LawOfCosine(double a, double b, double c)
    {
        double result = (Math.pow(b,2)+Math.pow(c,2)-Math.pow(a,2))/(2*b*c);
        return Math.acos(result);
    }



}
