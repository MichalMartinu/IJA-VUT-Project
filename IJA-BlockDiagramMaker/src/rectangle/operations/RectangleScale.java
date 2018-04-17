package rectangle.operations;

import rectangle.RectangleObject;

import java.util.SortedMap;
import java.util.TreeMap;

public class RectangleScale extends RectangleObject{

    private double scaling;

    public RectangleScale(SortedMap<String, Double> rectangle, double scaling) {
        super(rectangle);
        this.scaling = scaling;
    }

    public void execute()
    {
        this.a = this.a * 2;
        this.b = this.b * 2;
        this.a = Math.round(this.a * 1000000d)/1000000d;
        this.b = Math.round(this.b * 1000000d)/1000000d;
    }

    public SortedMap<String, Double> objectActualValue(){
        SortedMap<String, Double> result = new TreeMap<>();
        result.put("a", this.a);
        result.put("b", this.b);
        return result;
    }
}
