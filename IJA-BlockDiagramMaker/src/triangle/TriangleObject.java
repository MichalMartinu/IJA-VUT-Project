package triangle;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class TriangleObject extends AbstractBlock{
    public TriangleObject() {
        this.a = -1.0;
        this.b = -1.0;
        this.c = -1.0;
        this.state = "waiting";
        this.object = "Triangle";
    }

    private void CheckIfTriangleIsValid()
    {
        if (!((this.a + this.b > this.c) && (this.a + this.c > this.b) && (this.b + this.c > this.a)))
        {
            throw new IllegalArgumentException ("Invalid Triangle");
        }
    }

    public abstract void execute();

    public void check() throws Exception {

    }

}
