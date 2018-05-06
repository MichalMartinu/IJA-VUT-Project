package visualisation;

import block.AbstractBlock;

import java.util.ArrayList;

/**
 * Visual representation of block informations
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 */
public class Informations {

    /**
     * Return specified data visualisation
     * @param block block in scheme
     * @param index index of block in scheme
     * @return visual representation of block data
     */
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
