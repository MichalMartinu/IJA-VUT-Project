package visualisation;

import block.AbstractBlock;

import java.util.ArrayList;

public class Lines {
    public static ArrayList<String> inputLine(AbstractBlock block)
    {
        int input = block.getInput();
        ArrayList<String> output = new ArrayList<String>();
        if (input != -1){
            output.add("    ");
            output.add("    ");
            output.add("  |-");
            output.add("  | ");
            output.add("  |---------------------------" + lenOfLine(input));
        }
        else
        {
            output.add("    ");
            output.add("    ");
            output.add("    ");
            output.add("    ");
            output.add("    ");
        }
        return output;
    }
    private static String lenOfLine(int len)
    {
        String output = "";
        for (int i=0; i<len; i++)
        {
            output += "-";
        }
        return output;
    }
}

