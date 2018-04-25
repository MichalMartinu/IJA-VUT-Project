package actions;

import block.AbstractBlock;
import visualisation.Blocks;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class DrawScheme {
    private int index;

    public void drawBlock(AbstractBlock block)
    {
        ArrayList<String> output = new ArrayList<String>();

        output.addAll(Blocks.getBlock(block));

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }
}
