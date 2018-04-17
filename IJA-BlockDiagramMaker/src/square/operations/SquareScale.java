package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareScale extends SquareObject{

    private double scaling;

    public SquareScale(SortedMap<String, Double> square, double scaling) {
        super(square);
        this.scaling = scaling;
    }

    public void execute() {
        this.a =this.a * this.scaling;
        this.a = Math.round(this.a * 1000000d)/1000000d;
    }

    public SortedMap<String, Double> objectActualValue(){
        SortedMap<String, Double> result = new TreeMap<>();
        result.put("a", this.a);
        return result;
    }
}
