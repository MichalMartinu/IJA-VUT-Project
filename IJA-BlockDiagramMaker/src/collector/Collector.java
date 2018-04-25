package collector;

import block.AbstractBlock;
import blockInterface.Block;
import square.operations.SquareArea;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Collector {
    protected ArrayList<AbstractBlock> blocks = new ArrayList<AbstractBlock>();
    int counter;
   //protected SortedMap<String, AbstractBlock> blocks = new TreeMap<>();

    public Collector() {
    }


    public void setBlock(AbstractBlock block) {
        this.blocks.add(block);
        this.counter +=1;
    }

    public AbstractBlock getBlock(int key)
    {
        return this.blocks.get(key);
    }

    public int getCounter() {
        return counter;
    }

    public void setConnection(int output, int input, String as){
        if (output < blocks.size() && input < blocks.size())
        {
            getBlock(input).setInput(output);
        }
        //TODO Errror

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
        //TODO Error
    }

}
