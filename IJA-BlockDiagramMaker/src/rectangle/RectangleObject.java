package rectangle;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class RectangleObject extends AbstractBlock {

    public RectangleObject() {
        this.a = -1.0;
        this.b = -1.0;
        this.state = "waiting";
        this.object = "Rectangle";
    }

    public abstract void execute();

}
