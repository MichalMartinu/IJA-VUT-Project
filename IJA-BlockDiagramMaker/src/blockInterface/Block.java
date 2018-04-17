package blockInterface;

import java.util.SortedMap;

public interface Block {

    public SortedMap<String, Double> objectActualValue();

    public void execute();

}
