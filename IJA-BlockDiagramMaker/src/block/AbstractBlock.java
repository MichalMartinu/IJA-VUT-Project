package block;

import blockInterface.Block;

public abstract class AbstractBlock implements Block{

    public AbstractBlock()
    {
        super();
    }

    public abstract void execute();

    public abstract void check() throws Exception;


}
