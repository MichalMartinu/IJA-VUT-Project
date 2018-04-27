package actions;

import block.AbstractBlock;
import square.operations.*;

public class BlockTypes {

    public static AbstractBlock getType(String object, String operation)
    {
        switch (object)
        {
            case "Square":
                switch (operation)
                {
                    case "Area":
                        return new SquareArea();
                    case "Circumference":
                        return new SquareCircumference();
                    case "Diagonal":
                        return new SquareDiagonal();
                    case "Height":
                        return new SquareHeight();
                    case "Scale":
                        return new SquareScale(0);
                }
        }
        return null;
    }
}
