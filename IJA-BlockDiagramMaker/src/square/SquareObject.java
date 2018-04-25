package square;

import block.AbstractBlock;

import java.util.SortedMap;

public abstract class SquareObject extends AbstractBlock {
    protected double a;
    protected double output;
    protected double input;
    protected String state;

    public SquareObject() {
        this.a = -1.0;
        this.state = "waiting";
    }

    public void check() throws Exception {
        if(this.a == -1.0)
        {
            throw new Exception("Side A in a square is missing!");
        }
    }

    public abstract void execute();

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
