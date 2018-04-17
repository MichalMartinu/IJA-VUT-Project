package triangle;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class TriangleObject extends AbstractBlock{
    protected double a;
    protected double b;
    protected double c;

    public TriangleObject(SortedMap<String, Double> triangle)
    {
        a = triangle.get("a");
        b = triangle.get("b");
        c = triangle.get("c");
        CheckIfTriangleIsValid();
    }

    private void CheckIfTriangleIsValid()
    {
        if (!((this.a + this.b > this.c) && (this.a + this.c > this.b) && (this.b + this.c > this.a)))
        {
            throw new IllegalArgumentException ("Invalid Triangle");
        }
    }

    public abstract void execute();

    public abstract SortedMap<String, Double> objectActualValue();


}
