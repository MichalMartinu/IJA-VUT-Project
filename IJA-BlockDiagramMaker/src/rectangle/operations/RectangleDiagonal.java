package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleDiagonal extends RectangleObject {
    private double result;

    public RectangleDiagonal() {
        this.type = "Diagonal";
    }


    public void execute()
    {
        this.result = Math.sqrt(Math.pow(this.a,2) + Math.pow(this.b,2));
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }


}

