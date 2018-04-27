package actions;

import block.AbstractBlock;
import rectangle.operations.*;
import square.operations.*;
import triangle.operations.*;

public class BlockOperations {

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
            case "Rectangle":
                switch (operation)
                {
                    case "Area":
                        return new RectangleArea();
                    case "Circumference":
                        return new RectangleCircumference();
                    case "Diagonal":
                        return new RectangleDiagonal();
                    case "Height":
                        return new RectangleHeight();
                    case "Scale":
                        return new RectangleScale();
                }
                break;
            case "Triangle":
                switch (operation)
                {
                    case "Area":
                        return new TriangleArea();
                    case "Circumference":
                        return new TriangleCircumference();
                    case "Diagonal":
                        return new TriangleGetAngle();
                    case "Height":
                        return new TriangleHeight();
                    case "Scale":
                        return new TriangleScale();
                }
        }
        return null;
    }


}
