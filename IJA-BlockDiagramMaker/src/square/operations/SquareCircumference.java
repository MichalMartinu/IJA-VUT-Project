package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareCircumference extends SquareObject{

    public SquareCircumference() {

    }

    public void execute()
    {
        double result;
        result = this.a * 4;
        result = Math.round(result * 1000000d)/1000000d;
        this.output = result;
        this.state = "done";
    }
}
