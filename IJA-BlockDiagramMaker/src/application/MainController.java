package application;

import actions.BlockOperations;
import actions.DrawScheme;
import block.AbstractBlock;
import collector.Collector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.*;

public class MainController {
    private Collector collector;
    private DrawScheme scheme;

    private ObservableList<String> objectList = FXCollections.observableArrayList();
    private ObservableList<String> operationsList = FXCollections.observableArrayList();
    private ObservableList<String> asList = FXCollections.observableArrayList();
    //public static final ObservableList data = FXCollections.observableArrayList();


    public void initialize()
    {
        collector = new Collector();
        scheme = new DrawScheme();
        loadObjects();
        loadOperations();
        loadSides();
        //dataBlock = new ListView();
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

    @FXML
    private Label dataBlock;

    @FXML
    private TextField sideA;

    @FXML
    private TextField sideB;

    @FXML
    private TextField sideC;

    @FXML
    private TextField sideBlock;

    @FXML
    private TextField blockToRemove;


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

    public void addSide(ActionEvent event) {
        //String a = sideA.getText();
        double a = Double.parseDouble(sideA.getText());
        //double b = Double.parseDouble(sideB.getText());
        //double c = Double.parseDouble(sideC.getText());
        int blockNum = Integer.parseInt(sideBlock.getText());
        //System.out.println(a);
        //System.out.println(blockNum);
        //this.collector.s(blockNum).setA(a);
        this.collector.changeBlockValue(blockNum, "a", a);
        drawLabel();
    }

    public void resetScheme(ActionEvent event)
    {
        collector = new Collector();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    public void removeBlock(ActionEvent event){
        int index = Integer.parseInt(blockToRemove.getText());
        collector.delete(index);
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    public void resetBlocks(ActionEvent event)
    {
        collector.reset();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    public void nextStep(ActionEvent event){
        this.collector.next();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    public void saveFile(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Scheme","*.save"));
        File selectedFile = fc.showSaveDialog(null);

        if(selectedFile != null) {
            this.collector.save(selectedFile);
            this.scheme = new DrawScheme();
            this.scheme.drawScene(this.collector);
            drawLabel();
        }
    }

    public void openFile(ActionEvent event) throws IOException, ClassNotFoundException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Scheme","*.save"));
        File selectedFile = fc.showOpenDialog(null);

        if(selectedFile != null)
        {
            this.collector = new Collector();
            this.collector.read(selectedFile);
            this.scheme = new DrawScheme();
            this.scheme.drawScene(this.collector);

            drawLabel();
        }


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

    private void addData()
    {
        //dataBlock.getChildren().clear();
        AbstractBlock block;
        String blockId;
        String outputValue ;
        String State;



        String outputText = "";

        for (int i = 0; i <  this.collector.getCounter(); i++) {
            //System.out.println( this.collector.getBlock(i));
             block = collector.getBlock(i);
             outputValue = Double.toString(block.getOutputResult());
             if (outputValue.equals("-1"))
             {
                 outputValue = "waiting for output";
             }

             blockId = Integer.toString(i+1);
             outputText += "   Block number: " + blockId + "\n";
             outputText += "   Input data\n";
             outputText += "       a: " + block.getA() + "\n"; //TODO na to udelat uni funkci
             outputText += "   Reuslt: " + outputValue + "\n\n";
         }
        dataBlock.setText(outputText);
    }


    private void drawLabel()
    {
        String listString = "";
        for (String s : scheme.getOutput())
        {
            listString += s + "\n";
        }
        textField.setText(listString);

        addData();
    }

    


}
