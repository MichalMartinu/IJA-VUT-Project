package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareDiagonal extends SquareObject {

    public SquareDiagonal(){

    }

    public void execute()
    {
        double result;
        result = this.a * Math.sqrt(2);
        result = Math.round(result * 1000000d)/1000000d;
        this.output = result;
        this.state = "done";
    }
}
