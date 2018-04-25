package actions;

import block.AbstractBlock;
import collector.Collector;
import visualisation.Blocks;
import visualisation.Lines;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class DrawScheme {
    ArrayList<String> output = new ArrayList<String>();

    public void drawScene(Collector collector){
        initScene(collector.getCounter());
        //TODO daky for
        int j = 0;
        for (int i = 0; i<collector.getCounter(); i++)
        {
            drawConnectionLineIn(collector.getBlock(i), j);
            drawBlock(collector.getBlock(i), j);
            j += 6;
        }

        for (int i = 0; i <  this.output.size(); i++) {
            System.out.println( this.output.get(i));
        }
    }

    public void drawConnectionLineIn(AbstractBlock block, int index){
        addToIndex(Lines.inputLine(block), index);
    }


    public void drawBlock(AbstractBlock block, int index)
    {
        //TODO change index and delete hej
        addToIndex(Blocks.getBlock(block), index);
    }

    public void addToIndex(ArrayList<String > item, int index)
    {
        int j = 0;
        for (int i = index; i<index+item.size(); i++)
        {
            this.output.set(i, this.output.get(i) + item.get(j++));
        }
    }

    public void initScene(int count){
        for (int i = 0; i < count*6; i++)
        {
            this.output.add("");
        }
    }
}
