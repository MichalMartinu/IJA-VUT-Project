package collector;

import actions.DrawScheme;
import block.AbstractBlock;

import java.io.*;
import java.util.ArrayList;

public class Collector{
    private ArrayList<AbstractBlock> blocks = new ArrayList<>();
    //private ArrayList<AbstractBlock> backup = new ArrayList<AbstractBlock>();
    private int counter;
    private int flagFirst;
    //protected SortedMap<String, AbstractBlock> blocks = new TreeMap<>();

    public Collector() {
        this.flagFirst = 0;
    }

    public void setBlock(AbstractBlock block) {
        this.blocks.add(block);
    }

    public AbstractBlock getBlock(int key) {
        return this.blocks.get(key);
    }

    public void changeBlockValue(int key, String type, Double value){
        if (type.equals("a")) {
            this.blocks.get(key).setA(value);
        }
        if (type.equals("b")) {
            this.blocks.get(key).setB(value);
        }
        if (type.equals("c")) {
            this.blocks.get(key).setC(value);
        }
    }

    public int getCounter() {
        return blocks.size();
    }

    public void delete(int index){
        AbstractBlock block;
        block = blocks.get(index);

        if(block.getOutput() != -1)
        {
            blocks.get(block.getOutput()).removeInput(index);
            String side = block.getOutputAs();
            switch (side)
            {
                case "a":
                    blocks.get(block.getOutput()).setA(-1);
                    break;
                case "b":
                    blocks.get(block.getOutput()).setB(-1);
                    break;
                case "c":
                    blocks.get(block.getOutput()).setC(-1);
                    break;
            }
        }

        if(block.getMaxInput() != -1)
        {
            ArrayList<Integer> input = block.getInputArray();

            for (int i = 0; i < input.size(); i++)
            {
                blocks.get(i).setOutput(-1);
            }
        }


        this.blocks.remove(index);

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
            getBlock(input).addInput(output);
            /*if (getBlock(input).getMaxInput() < output) {
                getBlock(input).setInput(output);
            }*/
        }

        switch (as)
        {
            case "a":
                getBlock(input).setA(0.0);
                break;
            case "b":
                getBlock(input).setB(0.0);
                break;
            case "c":
                getBlock(input).setC(0.0);
                break;
        }
    }

    public void next(){
        AbstractBlock tmpBlock;

        for (AbstractBlock block : this.blocks) {

            if (block.getState().equals("waiting")) {
                block.execute();
            }
            else if (block.getState().equals("calculated") && block.getOutput() != -1) {
                tmpBlock = this.blocks.get(block.getOutput());

                if (block.getOutputAs().equals("a")) {
                    tmpBlock.setA(block.getOutputResult());
                }
                else if (block.getOutputAs().equals("b")) {
                    tmpBlock.setB(block.getOutputResult());
                }
                else if (block.getOutputAs().equals("c")) {
                    tmpBlock.setC(block.getOutputResult());
                }

                this.blocks.set(block.getOutput(), tmpBlock);
                block.setState("done");
            }
            else if (block.getState().equals("calculated")) {
                block.setState("done");
            }
        }
    }

    public void save(File fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(blocks);
        oos.close();
    }

    public void read(File fileName) throws IOException, ClassNotFoundException {
        ArrayList<AbstractBlock> save = new ArrayList<AbstractBlock>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        save = (ArrayList<AbstractBlock>) ois.readObject();
        ois.close();
        this.blocks = save;
    }

}
