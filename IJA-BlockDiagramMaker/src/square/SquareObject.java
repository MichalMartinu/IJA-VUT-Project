package square;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class SquareObject extends AbstractBlock {


    public SquareObject() {
        this.a = -1.0;
        this.state = "waiting";
    }

    public void check() throws Exception {
        if(this.a == -1.0)
        {
            throw new Exception("Side A in a square is missing!");
        }
    }

    public abstract void execute();


}
