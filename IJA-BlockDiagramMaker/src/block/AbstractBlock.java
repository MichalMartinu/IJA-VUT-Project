package block;

import blockInterface.Block;

public abstract class AbstractBlock implements Block{
    protected double a;
    protected double b;
    protected double c;
    protected double outputResult;

    protected int output;
    protected String outputAs;
    protected int input;

    protected String state;
    protected String type;
    protected String object;

    public AbstractBlock()
    {
        output = -1;
        input = -1;
        a = -1;
        b = -1;
        c = -1;
    }

    public abstract void execute();

    public abstract void check() throws Exception;

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

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
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

}
