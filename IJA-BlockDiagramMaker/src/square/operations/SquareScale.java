package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareScale extends SquareObject{

    private double scaling;

    public SquareScale(double scaling) {
        this.scaling = scaling;
        this.type = "Scaling";
    }

    public void execute() {
        this.a =this.a * this.scaling;
        this.a = Math.round(this.a * 1000000d)/1000000d;
        this.state = "done";
    }
}
