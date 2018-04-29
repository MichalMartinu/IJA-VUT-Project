package visualisation;

import block.AbstractBlock;

import java.util.ArrayList;

public class Informations {
    public static ArrayList<String> data(AbstractBlock block, int index)
    {
        ArrayList<String> output = new ArrayList<String>();

        switch (block.getState())
        {
            case "waiting":
                output.add("       ");
                output.add("       ");
                output.add("   ");
                output.add("       ");
                output.add("       ");
                output.add("       ");
                break;
            case "done":
                output.add("       ");
                output.add("       ");
                output.add("X  ");
                output.add("       ");
                output.add("       ");
                output.add("       ");
                break;
            case "calculated":
                output.add("       ");
                output.add("       ");
                output.add("<- ");
                output.add("       ");
                output.add("       ");
                output.add("       ");
                break;
        }
        if(index < 9)
        {
            index++;
            output.set(2, " "+index+"  "+output.get(2));
        }
        else if(index < 19)
        {
            index++;
            output.set(2, " "+index+" "+output.get(2));
        }
        else if(index < 999)
        {
            index++;
            output.set(2, " "+index+""+output.get(2));
        }
        else
        {
            output.set(2, index+"    "+output.get(2));

        }



        return output;
    }
}
