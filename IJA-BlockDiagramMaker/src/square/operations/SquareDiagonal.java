package square.operations;

import square.SquareObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class SquareDiagonal extends SquareObject {

    private double result;

    public SquareDiagonal(SortedMap<String, Double> square) {
        super(square);
    }

    public void execute()
    {
        this.result = this.a * Math.sqrt(2);
        this.result = Math.round(this.result * 1000000d)/1000000d;
    }

    public SortedMap<String, Double> objectActualValue(){
        SortedMap<String, Double> result = new TreeMap<>();
        result.put("result", this.result);
        return result;
    }
}
