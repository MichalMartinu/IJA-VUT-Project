package square;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class SquareObject extends AbstractBlock {

    /**
     * Initialization of Square object
     */
    public SquareObject() {
        this.a = -1.0;
        this.state = "waiting";
        this.object = "Square";

    }

    /**
     * Checks if the object has correct values
     * @throws Exception Object pops up error when values aren't assigned
     */
    public void check() throws Exception {
        if(this.a == -1.0)
        {
            throw new Exception("Side A in a square is missing!");
        }
        if(this.b != -1.0)
        {
            throw new Exception("Incompatibile types!");
        }if(this.c != -1.0)
        {
            throw new Exception("Incompatibile types!");
        }
    }


    public abstract void execute();
}
