package triangle.operations;

import triangle.TriangleObject;


import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleArea extends TriangleObject{
    private double result;

    public TriangleArea(SortedMap<String, Double> triangle) {
        super(triangle);
    }

    public void execute()
    {
        double s = (this.a+this.b+this.c)/2;
        this.result = Math.sqrt(s*(s-this.a)*(s-this.b)*(s-this.c));
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }

    public SortedMap<String, Double> objectActualValue(){
        SortedMap<String, Double> result = new TreeMap<>();
        result.put("result", this.result);
        return result;
    }
}
