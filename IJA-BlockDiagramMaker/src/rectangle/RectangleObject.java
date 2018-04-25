package rectangle;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class RectangleObject extends AbstractBlock {
    protected double a;
    protected double b;

    public RectangleObject(SortedMap<String, Double> rectangle)
    {
        a = rectangle.get("a");
        b = rectangle.get("b");
    }
    public abstract void execute();

    public void check() throws Exception {

    }

}
