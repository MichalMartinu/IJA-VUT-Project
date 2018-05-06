package square.operations;

import square.SquareObject;
/**
 * Calculating div of rectangle
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class SquareDiv extends SquareObject {
    /**
     * Setting type of operation for square object
     */
    public SquareDiv(){
        this.type = "Div";
    }
    /**
     * runs calculation div of square object
     */
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
