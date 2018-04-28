package collector;

import block.AbstractBlock;

import java.io.*;
import java.util.ArrayList;

public class Collector {
    private ArrayList<AbstractBlock> blocks = new ArrayList<AbstractBlock>();
    //private ArrayList<AbstractBlock> backup = new ArrayList<AbstractBlock>();
    private int counter;
    private int flagFirst;
    //protected SortedMap<String, AbstractBlock> blocks = new TreeMap<>();

    public Collector() {
        this.flagFirst = 0;
    }


    public void setBlock(AbstractBlock block) {
        this.blocks.add(block);
        this.counter += 1;
    }

    public AbstractBlock getBlock(int key) {
        return this.blocks.get(key);
    }

    public void changeBlockValue(int key, String type, Double value) {
        if (type.equals("a")) {
            this.blocks.get(key).setA(value);
        }
    }

    public int getCounter() {
        return counter;
    }

    public void reset()
    {
      for (int i = 0; i <  this.blocks.size(); i++) {
        this.blocks.get(i).defaultBlock();
        }
    }


    public void setConnection(int output, int input, String as) {
        if (output < blocks.size() && input < blocks.size()) {
            getBlock(output).setOutputAs(as);
            getBlock(output).setOutput(input);
            if (getBlock(input).getInput() < output) {
                getBlock(input).setInput(output);
            }
        }
        //TODO Errror

        if (as == "a" && getBlock(input).getA() == -1) {
            getBlock(input).setA(0.0);
        } else if (as == "b" && getBlock(input).getB() == -1) {
            getBlock(input).setC(0.0);
        } else if (as == "c" && getBlock(input).getC() == -1) {
            getBlock(input).setC(0.0);
        }
        //TODO Error
    }

    public void next() {
        AbstractBlock tmpBlock;

        for (AbstractBlock block : this.blocks) {
            if (block.getState().equals("waiting")) {
                block.execute();
            } else if (block.getState().equals("calculated") && block.getOutput() != -1) {
                tmpBlock = this.blocks.get(block.getOutput());
                if (block.getOutputAs().equals("a")) {
                    tmpBlock.setA(block.getOutputResult());
                } else if (block.getOutputAs().equals("b")) {
                    tmpBlock.setB(block.getOutputResult());
                } else if (block.getOutputAs().equals("c")) {
                    tmpBlock.setC(block.getOutputResult());
                }

                this.blocks.set(block.getOutput(), tmpBlock);
                block.setState("done");
            } else if (block.getState().equals("calculated")) {
                block.setState("done");
            }
        }
    }

}
