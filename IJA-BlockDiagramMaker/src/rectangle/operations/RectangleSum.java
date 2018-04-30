package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleSum extends RectangleObject{

    public RectangleSum() {
        this.type = "Sum";
    }

    public void execute() {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = this.a + this.b;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }


}
