package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareSum extends SquareObject{

    public SquareSum() {
        this.type = "Sum";
    }

    public void execute() {
        if (this.a > 0)
        {
            Double result;
            result = Math.round(this.a * 1000000d)/1000000d;
            this.state = "calculated";
            this.outputResult = result;
        }

    }
}
