package square.operations;

import square.SquareObject;
/**
 * Calculating circumference of rectangle
 */
public class SquareCircumference extends SquareObject{
    /**
     * Setting type of operation for square object
     */
    public SquareCircumference() {
        this.type = "Circumference";
    }
    /**
     * runs calculation circumference of square object
     */
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
