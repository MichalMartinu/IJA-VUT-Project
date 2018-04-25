package collector;

import block.AbstractBlock;
import blockInterface.Block;
import square.operations.SquareArea;

import java.util.SortedMap;
import java.util.TreeMap;

public class Collector {
    protected SortedMap<String, AbstractBlock> blocks = new TreeMap<>();

    public Collector() {
    }

    public SortedMap<String, AbstractBlock> getBlocks() {
        return blocks;
    }

    public void setBlock(String key, AbstractBlock block) {
        this.blocks.put(key, block);
    }

    public AbstractBlock getBlock(String key)
    {
        return this.blocks.get(key);
    }

}
