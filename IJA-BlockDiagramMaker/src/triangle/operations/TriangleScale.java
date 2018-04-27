package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleScale extends TriangleObject{
    private double scaling;

    public TriangleScale() {
        this.type = "Scale";
    }


    public void execute() {
        this.a =this.a * this.scaling;
        this.b =this.b * this.scaling;
        this.c =this.c * this.scaling;
        this.a = Math.round(this.a * 1000000d)/1000000d;
        this.b = Math.round(this.b * 1000000d)/1000000d;
        this.c = Math.round(this.c * 1000000d)/1000000d;
    }


}
