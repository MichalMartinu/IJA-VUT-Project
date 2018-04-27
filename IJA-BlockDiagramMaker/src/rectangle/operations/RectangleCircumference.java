package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleCircumference extends RectangleObject {
    private double result;

    public RectangleCircumference() {
        this.type = "Circumference";
    }

    public void execute()
    {
        this.result = 2*(this.a + this.b);
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }


}
