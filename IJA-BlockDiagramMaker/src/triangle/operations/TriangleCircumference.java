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
        this.result = this.a+this.b+this.c;
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }


}

