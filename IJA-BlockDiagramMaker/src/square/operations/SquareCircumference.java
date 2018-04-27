package square.operations;

import square.SquareObject;

public class SquareCircumference extends SquareObject{

    public SquareCircumference() {
        this.type = "Circumference";
    }

    public void execute()
    {
        if (this.a != -1 && this.a != 0)
        {
            double result;
            result = this.a * 4;
            result = Math.round(result * 1000000d)/1000000d;
            this.outputResult = result;
            this.state = "calculated";
        }
    }
}
