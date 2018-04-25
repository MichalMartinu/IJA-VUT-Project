package tests;

import actions.DrawScheme;
import block.AbstractBlock;
import collector.Collector;

import org.junit.Assert;
import org.junit.Test;

import square.operations.*;

public class CollectorTests {


    @Test
    public void blocks()
    {
        AbstractBlock block;

        Collector blocksCollector = new Collector();
        block = new SquareDiagonal();
        blocksCollector.setBlock(block);
        block = new SquareArea();
        blocksCollector.setBlock(block);
        block = new SquareHeight();
        blocksCollector.setBlock( block);


        AbstractBlock ok;
        ok = blocksCollector.getBlock(1);
        ok.setA(4.0);
        ok.execute();

        Assert.assertEquals((Double) (16.0), (Double) ok.getOutputResult());

        blocksCollector.setConnection(2,0, "a");

        Assert.assertEquals(2,blocksCollector.getBlock(0).getInput());

        DrawScheme hej = new DrawScheme();
        hej.drawScene(blocksCollector);
    }


}

