package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleHeight extends RectangleObject{
    public RectangleHeight() {
        this.type = "Height";
    }

    public void execute()
    {
        Double result;
        result = this.b;
        result = Math.round(result * 1000000d)/1000000d;
        this.outputResult = result;
        this.state = "calculated";

    }


}
