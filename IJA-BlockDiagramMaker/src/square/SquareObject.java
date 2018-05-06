package square;

import block.AbstractBlock;

import java.util.SortedMap;

/**
 * Initialization of Square object
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public abstract class SquareObject extends AbstractBlock {

    /**
     * Check for correct values
     *
     */
    protected SquareObject() {
        this.a = -1.0;
        this.state = "waiting";
        this.object = "Square";

    }

    public abstract void execute();
}
