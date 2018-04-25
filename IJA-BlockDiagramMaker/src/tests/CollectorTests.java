package tests;

import block.AbstractBlock;
import collector.Collector;

import org.junit.Assert;
import org.junit.Test;

import square.operations.*;

public class CollectorTests {


    @Test
    public void AddBlocks()
    {
        AbstractBlock block;

        Collector blocksCollector = new Collector();
        block = new SquareDiagonal();
        blocksCollector.setBlock("1", block);
        block = new SquareArea();
        blocksCollector.setBlock("6", block);
        block = new SquareHeight();
        blocksCollector.setBlock("2", block);


        AbstractBlock ok;
        ok = blocksCollector.getBlock("2");
        ok.setA(4.0);
        ok.execute();

        Assert.assertEquals((Double) (4.0), (Double) ok.getOutput());

    }


}

