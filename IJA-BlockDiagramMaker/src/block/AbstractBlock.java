package block;

import blockInterface.Block;

public abstract class AbstractBlock implements Block{
    protected double a;
    protected double output;
    protected double input;
    protected String state;

    public AbstractBlock()
    {
        super();
    }

    public abstract void execute();

    public abstract void check() throws Exception;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
