/*package tests;

import org.junit.Assert;

import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

import square.operations.*;
import rectangle.operations.*;
import triangle.operations.*;
import connection.*;

public class ConnectTests {


    @Test
    public void ConnectionBasic()
    {
        Connection connect = new Connection(1);
        connect.setPortName("connect");
        connect.setPortType("data");
        SortedMap<String, Double> data = new TreeMap<>();
        data.put("a", 4.0);
        connect.putValue(data);
        data.put("b", 1.0);
        data.put("c", 2.0);
        connect.putValue(data);
        Assert.assertEquals((Double) 4.0, (Double) connect.getValue("a"));
        Assert.assertEquals((Double) 1.0, (Double) connect.getValue("b"));
        Assert.assertEquals((Double) 2.0, (Double) connect.getValue("c"));
        Assert.assertEquals( "connect",  connect.getPortName());
        Assert.assertEquals( "data",  connect.getPortType());
        Assert.assertEquals( "waiting",  connect.getInputPortState());
        Assert.assertEquals( "waiting",  connect.getOutputPortState());

    }


}*/

