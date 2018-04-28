package application;

import actions.BlockOperations;
import actions.DrawScheme;
import block.AbstractBlock;
import collector.Collector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    private Collector collector;
    private DrawScheme scheme;

    private ObservableList<String> objectList = FXCollections.observableArrayList();
    private ObservableList<String> operationsList = FXCollections.observableArrayList();
    private ObservableList<String> asList = FXCollections.observableArrayList();


    public void initialize()
    {
        collector = new Collector();
        scheme = new DrawScheme();
        loadObjects();
        loadOperations();
        loadSides();
    }

    @FXML
    private TextArea textField;

    @FXML
    private ChoiceBox<String> objectAdd;

    @FXML
    private ChoiceBox<String> operationAdd;

    @FXML
    private ChoiceBox<String> asPort;

    @FXML
    private TextField inputPort;

    @FXML
    private TextField outputPort;

    /*@FXML
    private TextField asPort;*/

    public void addBlock(ActionEvent event)
    {
        String object = objectAdd.getValue();
        String operation = operationAdd.getValue();

        if (object == null || operation == null)
        {
            alertAdd("Missing properties", "Specify object or operation!");
            return;
        }

        AbstractBlock block;

        block = BlockOperations.getType(object,operation);
        this.collector.setBlock(block);

        this.scheme.drawScene(this.collector);


        drawLabel();
    }

    public void connectBlock(ActionEvent event)
    {
        if (!(inputPort.getText().matches("[0-9]+") && outputPort.getText().matches("[0-9]+")))
        {
            alertAdd("Wrong ports", "Fill all ports by numbers!");
            return;
        }

        if (asPort.getValue() == null)
        {
            alertAdd("Missing side", "Please specify side!");
            return;
        }


        int input = Integer.parseInt(inputPort.getText());
        int output = Integer.parseInt(outputPort.getText());
        String as = asPort.getValue();

        collector.setConnection(input,output,as);
        this.scheme.drawScene(this.collector);
        drawLabel();

        //this.collector.setConnection();
    }

    public void resetScheme(ActionEvent event)
    {
        collector = new Collector();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    private void loadObjects()
    {
        objectList.removeAll();
        String a = "Square";
        String b = "Rectangle";
        String c = "Triangle";
        objectList.addAll(a,b,c);
        objectAdd.getItems().addAll(objectList);
    }

    private void loadOperations()
    {
        operationsList.removeAll();
        String a = "Area";
        String b = "Circumference";
        String c = "Diagonal";
        String d = "Height";
        String e = "Scale";
        operationsList.addAll(a,b,c,d,e);
        operationAdd.getItems().addAll(operationsList);
    }

    private void loadSides()
    {
        asList.removeAll();
        String a = "a";
        String b = "b";
        String c = "c";
        asList.addAll(a,b,c);
        asPort.getItems().addAll(asList);
    }

    private void alertAdd(String title, String header)
    {
        Alert a =  new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setTitle(title);
        a.showAndWait();
    }


    private void drawLabel()
    {
        String listString = "";
        for (String s : scheme.getOutput())
        {
            listString += s + "\n";
        }
        textField.setText(listString);
    }
}
