package square.operations;

import square.SquareObject;

public class SquareDiv extends SquareObject {

    public SquareDiv(){
        this.type = "Div";
    }

    public void execute()
    {
        if (this.a != -1 && this.a != 0)
        {
            double result;
            result = this.a;
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";
        }

    }
}
