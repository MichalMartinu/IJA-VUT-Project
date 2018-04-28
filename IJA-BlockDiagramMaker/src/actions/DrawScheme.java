package actions;

import block.AbstractBlock;
import collector.Collector;
import visualisation.Blocks;
import visualisation.Lines;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class DrawScheme {
    private ArrayList<String> output = new ArrayList<String>();


    public void drawScene(Collector collector){
        output.clear();

        //makeArrayList();
        AbstractBlock block;
        initScene(collector.getCounter());
        int j = 0;
        for (int i = 0; i<collector.getCounter(); i++)
        {
            block=collector.getBlock(i);
            drawConnectionLineIn(block, j);
            drawBlock(block, j);

            j += 6;
        }
        j = 0;
        for (int i = 0; i<collector.getCounter(); i++)
        {
            block=collector.getBlock(i);
            if (block.getOutput() != -1)
            {
                drawConnectionLineLeft(collector, i, j);
            }
            else
            {
                addToIndex(Lines.emptyConnection(collector), 0);
            }

            j += 6;
        }

        for (int i = 0; i<collector.getCounter(); i++)
        {
            block=collector.getBlock(i);

            if (block.getOutput() != -1)
            {
                for (int g = 0; g < i*2+2; g+=2)
                {
                    this.output.set(i*6+2,replaceString(this.output.get(i*6+2),g+27,'-'));
                    this.output.set(i*6+2,replaceString(this.output.get(i*6+2),g+28,'+'));
                }
            }
        }


        /*for (int i = 0; i <  this.output.size(); i++) {
            System.out.println( this.output.get(i));
        }*/
    }

    public void drawConnectionLineIn(AbstractBlock block, int index){
        addToIndex(Lines.inputLine(block), index);
    }

    public void drawConnectionLineLeft(Collector collector, int blockIndex, int index){
        AbstractBlock block = collector.getBlock(blockIndex);
        String type;
        String direction;
        int output =  block.getOutput();

        if (block.getOutput() > blockIndex)
        {
            direction="higher";
            for (int i = 0; i < blockIndex; i++) {

                type = "empty";

                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, blockIndex), i * 6);
            }
        }
        else
        {
            direction = "smaller";
            for (int i = 0; i < block.getOutput(); i++) {

                type = "empty";

                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, blockIndex), i * 6);
            }
        }



        block = collector.getBlock(blockIndex);


        if (direction.equals("higher")) {
            type = "outD";
            addToIndex(Lines.leftLine(block, type,blockIndex), index);
        } else {
            type = "outP";
            addToIndex(Lines.leftLine(block, type, blockIndex), index);
        }

        type="full";
        if (direction.equals("higher")) {
            for (int i = blockIndex+1; i < output; i++)
            {
                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, blockIndex), i*6);
            }
        } else {
            for (int i = output+1; i < blockIndex; i++)
            {
                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, blockIndex), i*6);
            }
        }

        block = collector.getBlock(blockIndex);
        index = block.getOutput();
        block = collector.getBlock(block.getOutput());

        if (direction.equals("higher")) {
            type = "inP";
            addToIndex(Lines.leftLine(block, type, blockIndex), index*6);
        } else {

            type = "inD";
            addToIndex(Lines.leftLine(block, type, blockIndex), index*6);
        }

        if (direction.equals("higher"))
        {
            block = collector.getBlock(blockIndex);
            type = "empty";
            for (int i = block.getOutput()+1; i < collector.getCounter(); i++)
            {
                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, output), i*6);
            }
        }
        else
        {
            type = "empty";
            for (int i = blockIndex+1; i < collector.getCounter(); i++)
            {
                block = collector.getBlock(i);
                addToIndex(Lines.leftLine(block, type, output), i*6);
            }
        }

    }


    public void drawBlock(AbstractBlock block, int index)
    {
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

    public String replaceString(String str, int index, char replace){
        if(str==null){
            return str;
        }else if(index<0 || index>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }

    public ArrayList<String> getOutput() {
        return output;
    }
}
