package rectangle;

import block.AbstractBlock;

import java.util.SortedMap;
/**
 * Initialization of Rectangle object
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public abstract class RectangleObject extends AbstractBlock {

    /**
    * Checks if the object has correct values
    */
    protected RectangleObject() {
        this.a = -1.0;
        this.b = -1.0;
        this.state = "waiting";
        this.object = "Rectangle";
    }

    public abstract void execute();

}
