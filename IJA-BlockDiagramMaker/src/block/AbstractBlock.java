package block;

import blockInterface.Block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractBlock implements Block, Serializable{
    protected double a;
    protected double b;
    protected double c;
    protected double outputResult;

    protected int output;
    protected String outputAs;
    private ArrayList<Integer> inputArray = new ArrayList<Integer>();


    protected String state;
    protected String type;
    protected String object;

    public AbstractBlock()
    {
        output = -1;
        inputArray.add(-1);
        a = -1;
        b = -1;
        c = -1;
        state = "waiting";

    }

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

    public void removeBlock()
    {
        a = -1;
        b = -1;
        c = -1;
    }

    public void addInput(Integer input)
    {
        inputArray.add(input);
    }

    public abstract void execute();


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getOutputResult() {
        return outputResult;
    }

    public String getOutputAs() {
        return outputAs;
    }

    public void setOutputAs(String outputAs) {
        this.outputAs = outputAs;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public int getMaxInput() {
        return Collections.max(inputArray);

    }

    public void removeInput(int input) {
        for (int i =0; i < inputArray.size(); i++)
        {
            if(inputArray.get(i) == input)
            {
                inputArray.remove(i);
            }
        }
    }

    public String getState() {

        return state;
    }

    public String getObject() {
        return object;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Integer> getInputArray() {
        return inputArray;
    }
}
