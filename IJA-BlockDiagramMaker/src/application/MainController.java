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

    @FXML
    private TextField dataBlockToRemove;

    @FXML
    private ChoiceBox<String> sideToRemove;



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


        int input = Integer.parseInt(inputPort.getText())-1;
        int output = Integer.parseInt(outputPort.getText())-1;
        String as = asPort.getValue();

        //Cycle detection

        if(collector.getBlock(output).getOutput() == input)
        {
            alertAdd("Cycle", "Cycle detected between block "+(input+1)+" and "+(output+1));
            return;
        }

        int flag = 0;
        for (int i = 0; i<collector.getCounter(); i++)
        {
            if(collector.getBlock(i).getOutput() == -1)
            {
                flag += 1;
            }
        }

        if(flag <= 1)
        {
            alertAdd("Cycle", "Cycle detected between whole scheme!");
            return;
        }


        collector.setConnection(input,output,as);
        this.scheme.drawScene(this.collector);
        drawLabel();



        //this.collector.setConnection();
    }

    public void addSide(ActionEvent event) {
        double a = -1,b = -1,c = -1;

        if (!(sideA.getText().equals("")))
        {
            a = Double.parseDouble(sideA.getText());
        }
        if (!(sideB.getText().equals("")))
        {
            b = Double.parseDouble(sideB.getText());
        }
        if (!(sideC.getText().equals("")))
        {
            c = Double.parseDouble(sideC.getText());
        }
        if (sideBlock.getText().equals("") || Integer.parseInt(sideBlock.getText()) < 0 || Integer.parseInt(sideBlock.getText())-1 > collector.getCounter())
        {
            alertAdd("Invalid block", "Adding to invalid block number!");
        }

        int blockNum = Integer.parseInt(sideBlock.getText())-1;
        switch (collector.getBlock(blockNum).getObject())
        {
            case "Square":
                if (b == -1 && c == -1 && a > 0)
                {
                    this.collector.changeBlockValue(blockNum, "a", a);

                }
                break;
            case "Rectangle":
                if (c == -1)
                {
                    if (a > 0)
                    {
                        this.collector.changeBlockValue(blockNum, "a", a);
                    }
                    if (b > 0)
                    {
                        this.collector.changeBlockValue(blockNum, "b", b);
                    }

                }
                break;
            case "Triangle":
                if (a > 0)
                {
                    this.collector.changeBlockValue(blockNum, "a", a);
                }
                if (b > 0)
                {
                    this.collector.changeBlockValue(blockNum, "b", b);
                }
                if (c > 0)
                {
                    this.collector.changeBlockValue(blockNum, "c", c);
                }
                break;
        }

        drawLabel();
    }

    public void resetScheme(ActionEvent event)
    {
        collector = new Collector();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    public void removeBlock(ActionEvent event){
        int index = Integer.parseInt(blockToRemove.getText())-1;
        int blockIndex = collector.getBlock(index).getOutput();
        collector.getBlock(blockIndex).removeBlock();
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
        AbstractBlock block;
        int flag = 0;

        for (int i = 0; i<collector.getCounter(); i++)
        {
            block = collector.getBlock(i);

            switch (block.getObject())
            {
                case "Square":
                    if(block.getA() == -1)
                    {
                        flag = 1;
                    }
                    break;
                case "Rectangle":
                    if(block.getA() == -1 || block.getB() == -1)
                    {
                        flag = 1;
                    }
                    break;
                case "Triangle":
                    if(block.getA() == -1 || block.getB() == -1 || block.getC() == -1)
                    {
                        flag = 1;
                    }
                    break;
            }

            if(flag == 1)
            {
                alertAdd("Missing values", "Please add all missing value where side is -1 into blocks!");
                return;
            }
        }

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

    public void dataToRemove(ActionEvent event)
    {
        int index = Integer.parseInt(dataBlockToRemove.getText())-1;

        if (sideToRemove.getValue() == null)
        {
            alertAdd("Missing side", "Please specify side!");
            return;
        }
        String as = sideToRemove.getValue();
        AbstractBlock block = collector.getBlock(index);
        int flag =0;
        switch (as)
        {
            case "a":
                if (block.getA() == 0)
                {
                    flag = 1;
                }
                else
                {
                    collector.getBlock(index).setA(-1);
                }
            case "b":
                if (block.getB() == 0)
                {
                    flag = 1;
                }
                else
                {
                    collector.getBlock(index).setA(-1);
                }
            case "c":
                if (block.getC() == 0)
                {
                    flag = 1;
                }
                else
                {
                    collector.getBlock(index).setA(-1);
                }
        }

        if (flag == 1)
        {
            alertAdd("Cannot be removed", "Side cannot be removed!");
            return;
        }


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
        String c = "Height";
        String d = "Div";
        String e = "Sum";
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
        sideToRemove.getItems().addAll(asList);
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
             outputText += "       a: " + block.getA() + "\n";
             if (collector.getBlock(i).getObject().equals("Rectangle"))
             {
                 outputText += "       b: " + block.getB() + "\n";
             }
            if (collector.getBlock(i).getObject().equals("Triangle"))
            {
                outputText += "       b: " + block.getB() + "\n";
                outputText += "       c: " + block.getC() + "\n";
            }

             outputText += "   Result: " + outputValue + "\n\n";
         }
        dataBlock.setText(outputText);
    }


    private void drawLabel()
    {
        String listString = "\n";
        for (String s : scheme.getOutput())
        {
            listString += s + "\n";
        }
        textField.setText(listString);

        addData();
    }


}
