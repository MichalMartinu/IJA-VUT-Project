package visualisation;

import block.AbstractBlock;

import java.util.ArrayList;

public class Blocks {

    public static ArrayList<String> getBlock(AbstractBlock block)
    {
        String mObject = block.getObject();
        String type = block.getType();
        ArrayList<String> output = new ArrayList<String>();

        if (mObject.equals("Square"))
        {
            switch (type)
            {
                case "Area":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|       Area     |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Circumference":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|  Circumference |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Div":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|       Div      |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Height":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|      Height    |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Sum":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|       Sum      |OUT|");
                    output.add("|-----------------------|");
                    break;


            }
        }
        if (mObject.equals("Rectangle"))
        {
            switch (type)
            {
                case "Area":
                    output.add("|-----------------------|");
                    output.add("|        Rectangle      |");
                    output.add("|IN|       Area     |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Circumference":
                    output.add("|-----------------------|");
                    output.add("|        Rectangle      |");
                    output.add("|IN|  Circumference |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Div":
                    output.add("|-----------------------|");
                    output.add("|        Rectangle      |");
                    output.add("|IN|        Div     |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Height":
                    output.add("|-----------------------|");
                    output.add("|        Rectangle      |");
                    output.add("|IN|      Height    |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Sum":
                    output.add("|-----------------------|");
                    output.add("|        Rectangle      |");
                    output.add("|IN|        Sum     |OUT|");
                    output.add("|-----------------------|");
                    break;


            }
        }
        if (mObject.equals("Triangle"))
        {
            switch (type)
            {
                case "Area":
                    output.add("|-----------------------|");
                    output.add("|        Triangle       |");
                    output.add("|IN|       Area     |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Circumference":
                    output.add("|-----------------------|");
                    output.add("|        Triangle       |");
                    output.add("|IN|  Circumference |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Div":
                    output.add("|-----------------------|");
                    output.add("|        Triangle       |");
                    output.add("|IN|       Div      |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Height":
                    output.add("|-----------------------|");
                    output.add("|        Triangle       |");
                    output.add("|IN|      Height    |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Sum":
                    output.add("|-----------------------|");
                    output.add("|        Triangle       |");
                    output.add("|IN|        Sum     |OUT|");
                    output.add("|-----------------------|");
                    break;


            }
        }
        return output;
    }

}
