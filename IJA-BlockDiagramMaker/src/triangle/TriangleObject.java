package triangle;

import block.AbstractBlock;

import java.util.SortedMap;

/**
 * Initialization of triangle object
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public abstract class TriangleObject extends AbstractBlock{

    /**
     * Checks if the object has correct values
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
