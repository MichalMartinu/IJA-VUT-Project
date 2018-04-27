package square.operations;

import square.SquareObject;

public class SquareArea extends SquareObject {

    public SquareArea() {
        this.type = "Area";
    }


    public void execute()
    {
        if (this.a != -1 && this.a != 0)
        {
            double result;
            result = Math.pow(this.a, 2);
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";
        }

    }
}
