package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleHeight extends TriangleObject {
    private double result;
    private String side;

    public TriangleHeight() {
        this.type = "Height";
    }


    public void execute()
    {
        double angle;

        if(this.side == "a")
        {
            angle = LawOfCosine(this.b, this.a, this.c); //Delta
            this.result = Math.sin(angle)*this.c;
        }
        else if(this.side == "b")
        {
            angle = LawOfCosine(this.c, this.a, this.b); //Beta
            this.result = Math.sin(angle)*this.a;
        }
        else if(this.side == "c")
        {
            angle = LawOfCosine(this.a, this.b, this.c); //Alpha
            this.result = Math.sin(angle)*this.b;
        }

        this.result = Math.round(this.result * 1000000d)/1000000d;

    }

    private double LawOfCosine(double a, double b, double c)
    {
        double result = (Math.pow(b,2)+Math.pow(c,2)-Math.pow(a,2))/(2*b*c);
        return Math.acos(result);
    }



}
