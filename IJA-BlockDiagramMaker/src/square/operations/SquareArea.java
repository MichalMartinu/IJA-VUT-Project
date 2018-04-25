package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareArea extends SquareObject {

    public SquareArea() {

    }


    public void execute()
    {
        double result;
        result = Math.pow(this.a, 2);
        result = Math.round(result * 1000000d)/1000000d;
        this.output = result;
        this.state = "done";
    }
}
