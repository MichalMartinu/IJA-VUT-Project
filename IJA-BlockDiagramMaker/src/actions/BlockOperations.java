package actions;

import block.AbstractBlock;
import rectangle.operations.*;
import square.operations.*;
import triangle.operations.*;

/**
* Creates new object depends on type of operation
*/
public class BlockOperations {

    /**
     * Creates new object depends on type of operation
     * @param object Type of object
     * @param operation Object operation
     * @return Returns new object depended on input parameters
     */
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
                    case "Div":
                        return new SquareDiv();
                    case "Height":
                        return new SquareHeight();
                    case "Sum":
                        return new SquareSum();
                }
            case "Rectangle":
                switch (operation)
                {
                    case "Area":
                        return new RectangleArea();
                    case "Circumference":
                        return new RectangleCircumference();
                    case "Div":
                        return new RectangleDiv();
                    case "Height":
                        return new RectangleHeight();
                    case "Sum":
                        return new RectangleSum();
                }
                break;
            case "Triangle":
                switch (operation)
                {
                    case "Area":
                        return new TriangleArea();
                    case "Circumference":
                        return new TriangleCircumference();
                    case "Div":
                        return new TriangleDiv();
                    case "Height":
                        return new TriangleHeight();
                    case "Sum":
                        return new TriangleSum();
                }
        }
        return null;
    }


}
