package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleCircumference extends TriangleObject{
    private double result;

    public TriangleCircumference() {
        this.type = "Circumference";
    }


    public void execute()
    {
        Double result;

        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            result = this.a+this.b+this.c;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }
    }



}

