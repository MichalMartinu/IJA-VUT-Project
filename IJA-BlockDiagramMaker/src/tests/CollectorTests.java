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
        block = new SquareCircumference();
        blocksCollector.setBlock( block);
        block = new SquareScale(0);
        blocksCollector.setBlock( block);
        block = new SquareScale(0);
        blocksCollector.setBlock( block);


        AbstractBlock ok;
        ok = blocksCollector.getBlock(1);
        ok.setA(4.0);
        ok.execute();

        Assert.assertEquals((Double) (16.0), (Double) ok.getOutputResult());

        blocksCollector.setConnection(1,2, "a");
        blocksCollector.setConnection(2,3, "a");
        blocksCollector.setConnection(4,0, "a");
        blocksCollector.setConnection(3,1, "a");
        blocksCollector.setConnection(5,1, "a");

        //Assert.assertEquals(-1,blocksCollector.getBlock(1).getInput());

        DrawScheme hej = new DrawScheme();
        hej.drawScene(blocksCollector);
    }


}

