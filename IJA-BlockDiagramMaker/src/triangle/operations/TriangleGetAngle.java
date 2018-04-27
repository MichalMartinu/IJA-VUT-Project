package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleGetAngle extends TriangleObject {
    private double result;
    private String angle;

    public TriangleGetAngle() {
        this.type = "Diagonal";
    }


    public void execute()
    {
        if(this.angle == "alpha")
        {
            this.result = LawOfCosine(this.a, this.b, this.c);
        }
        else if(this.angle == "beta")
        {
            this.result = LawOfCosine(this.c, this.a, this.b);
        }
        else if(this.angle == "delta")
        {
            this.result = LawOfCosine(this.b, this.a, this.c);
        }

        this.result = Math.round(this.result * 1000000d)/1000000d;

    }

    private double LawOfCosine(double a, double b, double c)
    {
        double result = (Math.pow(b,2)+Math.pow(c,2)-Math.pow(a,2))/(2*b*c);
        return Math.acos(result);
    }


}
