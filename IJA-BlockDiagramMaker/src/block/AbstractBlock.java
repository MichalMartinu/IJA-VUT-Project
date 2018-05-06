package block;

import blockInterface.Block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Abstract block used in scheme as multiple types.
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 * */
public abstract class AbstractBlock implements Block, Serializable{
    protected double a;             //Side A of object
    protected double b;             //Side B of object
    protected double c;             //Side C of object
    protected double outputResult;  //Result on output port

    protected int output;                                         //Output port
    protected String outputAs;                                    //Type of output side {a, b, c}
    private ArrayList<Integer> inputArray = new ArrayList<Integer>();   //Array of input ports

    protected String state;     //State of object {waiting, calculated, done}
    protected String type;      //Type of operation
    protected String object;    //Type of object

    /**
     * Initializes abstract block
     * */
    public AbstractBlock()
    {
        output = -1;
        inputArray.add(-1);
        a = -1;
        b = -1;
        c = -1;
        state = "waiting";
    }

    /**
     * Creates default values of block.
     * */
    public void defaultBlock()
    {
        outputResult = 0;
        if(Collections.max(inputArray) != -1)
        {
            a = 0;
            b = 0;
            c = 0;
        }
        state = "waiting";
    }

    /**
     * Remove values of block, making it to initialized state.
     * */
    public void removeBlock()
    {
        a = -1;
        b = -1;
        c = -1;
    }


    /**
     * Adds input into array of input ports.
     * @param input Input port
     * */
    public void addInput(Integer input)
    {
        inputArray.add(input);
    }

    /**
     *  Execute operations
     */
    public abstract void execute();


    /**
     * @return side A
     * */
    public double getA() {
        return a;
    }


    /**
     * @param a set side A
     * */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return side B
     * */
    public double getB() {
        return b;
    }

    /**
     * @param b set side B
     * */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return side C
     */
    public double getC() {
        return c;
    }

    /**
     * @param c set side C
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * @return result of block
     */
    public double getOutputResult() {
        return outputResult;
    }

    /**
     * @return type of output side
     */
    public String getOutputAs() {
        return outputAs;
    }

    /**
     * Sets type of side.
     * @param outputAs type of side
     */
    public void setOutputAs(String outputAs) {
        this.outputAs = outputAs;
    }

    /**
     * @return output port
     */
    public int getOutput() {
        return output;
    }

    /**
     * Sets output port.
     * @param output output port
     */
    public void setOutput(int output) {
        this.output = output;
    }

    /**
     * Gets max value of input port.
     * @return max value of input port
     */
    public int getMaxInput() {
        return Collections.max(inputArray);

    }

    /**
     * Removes specified number of port.
     * @param input number of port
     */
    public void removeInput(int input) {
        for (int i =0; i < inputArray.size(); i++)
        {
            if(inputArray.get(i) == input)
            {
                inputArray.remove(i);
            }
        }
    }

    /**
     * @return state of block
     */
    public String getState() {

        return state;
    }

    /**
     * @return object
     */
    public String getObject() {
        return object;
    }

    /**
     * sets state
     * @param state state of object
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return type of operation
     */
    public String getType() {
        return type;
    }

    /**
     * @return array of input ports
     */
    public ArrayList<Integer> getInputArray() {
        return inputArray;
    }
}
