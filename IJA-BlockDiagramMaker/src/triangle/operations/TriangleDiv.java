package triangle.operations;

import triangle.TriangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class TriangleDiv extends TriangleObject {

    public TriangleDiv() {
        this.type = "Div";
    }

    public void execute() {
        if (this.a > 0 && this.b > 0 && this.c > 0)
        {
            Double result;
            result = this.a / this.b / this.c;
            result = Math.round(result * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }


}
