package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleArea extends RectangleObject {

    private double result;

    public RectangleArea() {
        this.type = "Area";
    }

    public void execute()
    {
        this.result = this.a * this.b;
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }

}