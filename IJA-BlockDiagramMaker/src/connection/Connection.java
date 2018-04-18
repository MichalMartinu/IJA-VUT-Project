package connection;

import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class Connection {
    private SortedMap<String, Double> ports;
    private String portName;
    private String portType;
    private String inputPortState;
    private String outputPortState;
    private int id;

    public Connection(int i) {
        this.id = i;
        inputPortState = "waiting";
        outputPortState = "waiting";
    }

    public void putValue(SortedMap<String, Double> inputData){
        this.ports = inputData;
    }

    public double getValue(String valueType) {
        return ports.get(valueType);
    }

    public int getId() {
        return id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    public String getInputPortState() {
        return inputPortState;
    }

    public String getOutputPortState() {
        return outputPortState;
    }

    public void setInputPortState(String inputPortState) {
        this.inputPortState = inputPortState;
    }

    public void setOutputPortState(String outputPortState) {
        this.outputPortState = outputPortState;
    }
}
