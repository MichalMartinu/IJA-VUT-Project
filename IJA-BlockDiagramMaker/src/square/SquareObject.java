package square;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class SquareObject extends AbstractBlock {
    protected double a;

    public SquareObject(SortedMap<String, Double> square)
    {
        a = square.get("a");
    }
    public abstract void execute();

    public abstract SortedMap<String, Double> objectActualValue();

}
