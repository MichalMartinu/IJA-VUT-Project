package visualisation;

import block.AbstractBlock;
import collector.Collector;

import java.util.ArrayList;

public class Lines {
    public static ArrayList<String> inputLine(AbstractBlock block)
    {
        int input = block.getInput();
        ArrayList<String> output = new ArrayList<String>();
        if (input != -1){
            output.add("  ");
            output.add("  ");
            output.add("|-");
            output.add("| ");
            output.add("|---------------------------+" + lenOfLine(input));
            output.add("                           ");

        }
        else
        {
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("                           ");
            output.add("                           ");
        }
        return output;
    }

    public static ArrayList<String> leftLine(AbstractBlock block, String type, int outputIndex)
    {
        int inputPort = block.getInput();
        ArrayList<String> output = new ArrayList<String>();
        switch(type)
        {
            case "full":
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                break;
            case "outD":
                output.add("  ");
                output.add("  ");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                break;
            case "outP":
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                break;
            case "inD":
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add(" |");
                break;
            case "inP":
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add(" |");
                output.add("  ");
                break;
            case "empty":
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                output.add("  ");
                break;
        }
        if (inputPort != -1 && outputIndex <= inputPort)
        {
            output.set(4, "");
        }

        return output;
    }

    public static ArrayList<String> emptyConnection(Collector collector){
        ArrayList<String> output = new ArrayList<String>();
        AbstractBlock block;
        int j = 0;
        for (int i = 0; i < collector.getCounter(); i++)
        {
            block=collector.getBlock(i);

            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");

            /*if(block.getOutput() < i && block.getInput() != -1)
            {
                output.set(j+4, "");
            }
            else
            {
                if (block.getInput() != -1)
                {
                    output.set(j+4, "");
                }
            }*/



            j+=6;

        }

        return output;
    }

    private static String lenOfLine(int len)
    {
        String output = "";
        for (int i=0; i<len; i++)
        {
            output += "-+";
        }
        return output;
    }
}

