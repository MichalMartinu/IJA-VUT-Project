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
       /* block = new SquareHeight();
        blocksCollector.setBlock( block);
        block = new SquareHeight();
        blocksCollector.setBlock( block);
        block = new SquareHeight();
        blocksCollector.setBlock( block);*/



        AbstractBlock ok;
        ok = blocksCollector.getBlock(1);
        ok.setA(4.0);
        ok.execute();

        Assert.assertEquals((Double) (16.0), (Double) ok.getOutputResult());

        blocksCollector.setConnection(0,2, "a");
        blocksCollector.setConnection(2,1, "a");
        //blocksCollector.setConnection(1,5, "a");
        //blocksCollector.setConnection(2,5, "a");
        /*blocksCollector.setConnection(2,2, "a");
        blocksCollector.setConnection(3,0, "a");
        blocksCollector.setConnection(5,3, "a");*/

        //Assert.assertEquals(-1,blocksCollector.getBlock(1).getInput());

        DrawScheme hej = new DrawScheme();
        hej.drawScene(blocksCollector);
    }

    @Test
    public void nextSimple()
    {
        AbstractBlock block;
        Collector blocksCollector = new Collector();

        block = new SquareDiagonal();
        blocksCollector.setBlock(block);
        block = new SquareArea();
        blocksCollector.setBlock(block);
        block = new SquareHeight();
        blocksCollector.setBlock(block);

        blocksCollector.getBlock(1).setA(2.0);
        blocksCollector.getBlock(2).setA(3.0);

        blocksCollector.next();
        blocksCollector.next();

        Assert.assertEquals((Double) 4.0, (Double) blocksCollector.getBlock(1).getOutputResult());
        Assert.assertEquals((Double) 3.0,(Double) blocksCollector.getBlock(2).getOutputResult());
        Assert.assertEquals((Double) (-1.0),(Double) blocksCollector.getBlock(0).getA());
        Assert.assertEquals((String) "waiting",(String) blocksCollector.getBlock(0).getState());

        blocksCollector.getBlock(0).setA(2.0);
        blocksCollector.next();
        blocksCollector.next();
        Assert.assertEquals((Double) 2.0,(Double) blocksCollector.getBlock(0).getA());
        Assert.assertEquals((String) "done",(String) blocksCollector.getBlock(0).getState());
    }

    @Test
    public void nextConnection()
    {
        AbstractBlock block;
        Collector blocksCollector = new Collector();

        block = new SquareDiagonal();
        blocksCollector.setBlock(block);
        block = new SquareArea();
        blocksCollector.setBlock(block);
        block = new SquareHeight();
        blocksCollector.setBlock(block);

        blocksCollector.setConnection(1,2, "a");


        blocksCollector.getBlock(1).setA(2.0);

        blocksCollector.next();

        Assert.assertEquals((Double) 4.0, (Double) blocksCollector.getBlock(1).getOutputResult());
        Assert.assertEquals((Double) 0.0,(Double) blocksCollector.getBlock(2).getOutputResult());
        Assert.assertEquals((String) "waiting",(String) blocksCollector.getBlock(0).getState());
        Assert.assertEquals((String) "calculated",(String) blocksCollector.getBlock(1).getState());
        Assert.assertEquals((String) "waiting",(String) blocksCollector.getBlock(2).getState());

        blocksCollector.next();
        Assert.assertEquals((Double) 4.0, (Double) blocksCollector.getBlock(1).getOutputResult());
        Assert.assertEquals((Double) 4.0,(Double) blocksCollector.getBlock(2).getOutputResult());
        Assert.assertEquals((String) "waiting",(String) blocksCollector.getBlock(0).getState());
        Assert.assertEquals((String) "done",(String) blocksCollector.getBlock(1).getState());
        Assert.assertEquals((String) "calculated",(String) blocksCollector.getBlock(2).getState());;

        blocksCollector.next();
        Assert.assertEquals((String) "done",(String) blocksCollector.getBlock(2).getState());;
    }


}

