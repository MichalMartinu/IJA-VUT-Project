package square.operations;

import square.SquareObject;

public class SquareDiagonal extends SquareObject {

    public SquareDiagonal(){
        this.type = "Diagonal";
    }

    public void execute()
    {
        double result;
        result = this.a * Math.sqrt(2);
        result = Math.round(result * 1000000d)/1000000d;
        this.outputResult = result;
        this.state = "done";
    }
}