package block;

import blockInterface.Block;

import java.util.SortedMap;

public abstract class AbstractBlock implements Block{

    public AbstractBlock()
    {
        super();
    }
    public abstract void execute();

    public abstract SortedMap<String, Double> objectActualValue();
}
