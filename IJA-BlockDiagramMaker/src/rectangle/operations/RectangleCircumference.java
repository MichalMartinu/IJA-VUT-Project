package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleCircumference extends RectangleObject {
    public RectangleCircumference() {
        this.type = "Circumference";
    }

    public void execute()
    {
        if (this.a > 0 && this.b > 0)
        {
            Double result;
            result = 2*(this.a + this.b);
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";

        }
    }

}
