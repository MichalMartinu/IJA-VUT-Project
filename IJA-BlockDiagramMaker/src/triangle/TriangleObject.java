package triangle;

import block.AbstractBlock;

import java.util.SortedMap;

/**
 * Initialization of triangle object
 */
public abstract class TriangleObject extends AbstractBlock{

    /**
     * Checks if the object has correct values
     * @throws Exception Object pops up error when values aren't assigned
     */
    protected TriangleObject() {
        this.a = -1.0;
        this.b = -1.0;
        this.c = -1.0;
        this.state = "waiting";
        this.object = "Triangle";
    }

    public abstract void execute();
}
