package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleHeight extends RectangleObject{

    private double result;

    public RectangleHeight() {
        this.type = "Height";
    }

    public void execute()
    {
        this.result = this.b;
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }


}
