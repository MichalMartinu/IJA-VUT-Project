package square.operations;

import square.SquareObject;

public class SquareHeight extends SquareObject {

    public SquareHeight(){
        this.type = "Height";

    }
    public void execute() {
        double result;
        result = this.a;
        result = Math.round(result * 1000000d)/1000000d;
        this.outputResult = result;
        this.state = "done";
    }
}
