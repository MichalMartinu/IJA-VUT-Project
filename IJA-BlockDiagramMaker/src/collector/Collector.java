package collector;

import actions.DrawScheme;
import block.AbstractBlock;

import java.io.*;
import java.util.ArrayList;

/**
 * Collector of all blocks in scheme
 */
public class Collector{
    private ArrayList<AbstractBlock> blocks = new ArrayList<>();
    private int flagFirst;

    /**
     * Initialization of collector
     */
    public Collector() {
        this.flagFirst = 0;
    }

    /**
     * Add block into collector
     * @param block block to add
     */
    public void setBlock(AbstractBlock block) {
        this.blocks.add(block);
    }

    /**
     * Get block from collector
     * @param key index block
     * @return block
     */
    public AbstractBlock getBlock(int key) {
        return this.blocks.get(key);
    }

    /**
     * Change specified value of block
     * @param key index of block in collector
     * @param type side of block
     * @param value new value
     */
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

    /**
     * @return size of collector
     */
    public int getCounter() {
        return blocks.size();
    }

    /**
     * Delete specified block in collector
     * @param index index of block to delete
     */
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

    /**
     * Reset all blocks
     */
    public void reset()
    {
      for (int i = 0; i <  this.blocks.size(); i++) {
        this.blocks.get(i).defaultBlock();
        }
    }

    /**
     * Create new connection between two blocks
     * @param output output port
     * @param input input port
     * @param as side of connection
     */
    public void setConnection(int output, int input, String as) {
        if (output < blocks.size() && input < blocks.size()) {
            getBlock(output).setOutputAs(as);
            getBlock(output).setOutput(input);
            getBlock(input).addInput(output);
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

    /**
     * Execute one step in scheme
     */
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

    /**
     * Save collector into file
     * @param fileName path of file
     * @throws IOException when cant save into file
     */
    public void save(File fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(blocks);
        oos.close();
    }

    /**
     * Load collector from file
     * @param fileName path of file
     * @throws IOException when cant load into file
     */
    public void read(File fileName) throws IOException, ClassNotFoundException {
        ArrayList<AbstractBlock> save = new ArrayList<AbstractBlock>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        save = (ArrayList<AbstractBlock>) ois.readObject();
        ois.close();
        this.blocks = save;
    }

}
