package square;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class SquareObject extends AbstractBlock {

    /**
     * Initialization of Square object
     */
    protected SquareObject() {
        this.a = -1.0;
        this.state = "waiting";
        this.object = "Square";

    }

    public abstract void execute();
}
