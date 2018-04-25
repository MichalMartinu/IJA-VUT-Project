package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareHeight extends SquareObject {

    public SquareHeight(){

    }
    public void execute() {
        double result;
        result = this.a;
        result = Math.round(result * 1000000d)/1000000d;
        this.output = result;
        this.state = "done";
    }
}
