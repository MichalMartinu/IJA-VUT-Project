package collector;

import block.AbstractBlock;
import blockInterface.Block;
import square.operations.SquareArea;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Collector {
    protected ArrayList<AbstractBlock> blocks = new ArrayList<AbstractBlock>();

   //protected SortedMap<String, AbstractBlock> blocks = new TreeMap<>();

    public Collector() {
    }


    public void setBlock(AbstractBlock block) {
        this.blocks.add(block);
    }

    public AbstractBlock getBlock(int key)
    {
        return this.blocks.get(key);
    }

    public void setConnection(int output, int input, String as){
        getBlock(input).setInput(output);
        if (as == "a")
        {
            getBlock(input).setA(0.0);
        }
        else if (as == "b")
        {
            getBlock(input).setC(0.0);
        }
        else if (as == "c")
        {
            getBlock(input).setC(0.0);
        }
    }

}
