package visualisation;

import block.AbstractBlock;
import collector.Collector;

import java.util.ArrayList;

/**
 * Visual representation of block connection
 */
public class Lines {

    /**
     * Return visual representation of input line
     * @param block block in scheme
     * @return input line visualisation
     */
    public static ArrayList<String> inputLine(AbstractBlock block)
    {
        int input = block.getMaxInput();
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

    /**
     * Return visual representation of output line
     * @param block block in scheme
     * @param type type of line
     * @param outputIndex of output block
     * @return output line visualisation
     */
    public static ArrayList<String> leftLine(AbstractBlock block, String type, int outputIndex)
    {
        int inputPort = block.getMaxInput();
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

    /**
     * Make empty connection on whole scheme
     * @param collector scheme to edit
     * @return new visualisation
     */
    public static ArrayList<String> emptyConnection(Collector collector){
        ArrayList<String> output = new ArrayList<String>();
        AbstractBlock block;
        int j = 0;
        for (int i = 0; i < collector.getCounter(); i++)
        {
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");
            output.add("  ");

            j+=6;
        }

        return output;
    }

    /**
     * Set len of input line
     * @param len length of line
     * @return new visualisation
     */
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

