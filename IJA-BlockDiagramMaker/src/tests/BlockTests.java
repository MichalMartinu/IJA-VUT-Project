package tests;

import org.junit.Assert;

import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

import square.operations.*;

public class BlockTests {


    @Test
    public void blockInit() throws Exception {
        SquareArea block = new SquareArea();
        Assert.assertEquals("waiting", block.getState());
        Assert.assertEquals((Double) (-1.0), (Double) block.getA());
        block.setA(2.0);
        block.check();
    }

    @Test(expected = Exception.class)
    public void blockMissingValue() throws Exception {
        SquareHeight block = new SquareHeight();
        block.check();
    }

    @Test
    public void blockExecute() throws Exception {
        SquareArea block = new SquareArea();
        block.setA(5.0);
        block.check();
        block.execute();
        Assert.assertEquals("done", block.getState());
        Assert.assertEquals((Double) (25.0), (Double) block.getOutput());
    }
}

