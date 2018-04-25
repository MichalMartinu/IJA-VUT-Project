package visualisation;

import block.AbstractBlock;

import java.util.ArrayList;

public class Blocks {

    public static ArrayList<String> getBlock(AbstractBlock block)
    {
        String mObject = "Square";
        String type = block.getType();
        ArrayList<String> output = new ArrayList<String>();

        if (mObject == "Square")
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
                case "Diagonal":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|     Diagonal   |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Height":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|      Height    |OUT|");
                    output.add("|-----------------------|");
                    break;
                case "Scale":
                    output.add("|-----------------------|");
                    output.add("|         Square        |");
                    output.add("|IN|      Scale     |OUT|");
                    output.add("|-----------------------|");
                    break;


            }
        }
        return output;
    }

}