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

import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * GUI controller
 * @author Michal Martinů
 * @author Vojtěch Hromádka
 * */
public class MainController {
    private Collector collector;    //All blocks in scheme
    private DrawScheme scheme;      //Visual representation of scheme

    private ObservableList<String> objectList = FXCollections.observableArrayList();        //List of possible objects
    private ObservableList<String> operationsList = FXCollections.observableArrayList();    //List of possible operation
    private ObservableList<String> asList = FXCollections.observableArrayList();            //List of possible sides

    /**
     * Initialize variables and default scheme
     * */
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

    @FXML
    private Label mouseTextLab;

    @FXML
    private TextField outputDelete;


    /**
     * Add block into scheme and draw new sheme
     * @param event when button is pressed
     */
    public void addBlock(ActionEvent event)
    {
        String object = objectAdd.getValue();       //Type of object
        String operation = operationAdd.getValue(); //Type of operations

        if (object == null || operation == null)
        {
            alertAdd("Missing properties", "Specify object or operation!");
            return;
        }

        AbstractBlock block;

        block = BlockOperations.getType(object,operation);
        this.collector.setBlock(block);

        //Draw scheme
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Execute all operations a show result
     * @param event when button is pressed
     */
    public void runProgram(ActionEvent event)
    {
        int flag = 0;   //Flag used when execution is finished

        //Execute whole scheme
        for (int i = 0; i < collector.getCounter()+1; i++)
        {
            flag = nextStep(event);
            if (flag == 1)
            {
                return;
            }
        }

        //Show all results
        for (int i = 0; i < collector.getCounter(); i++)
        {
            if (collector.getBlock(i).getOutput() == -1)
            {
                informationAdd("Result", "Result of block " + (i+1)+" is: "+collector.getBlock(i).getOutputResult());
            }
        }

    }

    /**
     * Connect two block
     * @param event when button is pressed
     */
    public void connectBlock(ActionEvent event)
    {
        //Check if ports are number
        if (!(inputPort.getText().matches("[0-9]+") && outputPort.getText().matches("[0-9]+")))
        {
            alertAdd("Wrong ports", "Fill all ports by numbers!");
            return;
        }

        //Check if number of block is valid block
        if (Integer.parseInt(inputPort.getText()) <= 0 || Integer.parseInt(inputPort.getText()) > collector.getCounter())
        {
            alertAdd("Invalid block", "Invalid block number!");
            return;
        }

        //Check if number of block is valid block
        if (Integer.parseInt(outputPort.getText()) <= 0 || Integer.parseInt(outputPort.getText()) > collector.getCounter())
        {
            alertAdd("Invalid block", "Invalid block number!");
            return;
        }

        //Check if as side is set
        if (asPort.getValue() == null)
        {
            alertAdd("Missing side", "Please specify side!");
            return;
        }

        int input = Integer.parseInt(inputPort.getText())-1;    //Index of input port
        int output = Integer.parseInt(outputPort.getText())-1;  //Index of output port

        //Error when there is only one block set
        if (input == output)
        {
            alertAdd("Same block", "Cannot connect only one block!");
            return;
        }

        //Error when block already has value
        if (collector.getBlock(input).getOutput() != -1)
        {
            alertAdd("Cannot connect", "Cannot connect output is already specified!");
            return;
        }


        String as = asPort.getValue();  //Side of output
        int flag = 0;                   //Flag when error occurs is set to 1

        //Check if input is valid
        switch (collector.getBlock(output).getObject())
        {
            case "Square":
                if (as.equals("b") || as.equals("c"))
                {
                    flag =1;
                }
                break;
            case "Rectangle":
                if (as.equals("c"))
                {
                    flag =1;
                }
                break;
        }
        if(flag == 1)
        {
            alertAdd("Wrong side", "Wrong side of connection!");
            return;
        }



        //Cycle detection
        if(collector.getBlock(output).getOutput() == input)
        {
            alertAdd("Cycle", "Cycle detected between block "+(input+1)+" and "+(output+1));
            return;
        }

        flag = 0;
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

        //Check if block already has output value on all ports
        switch (as)
        {
            case "a":
                if (collector.getBlock(output).getA() != -1)
                {
                    flag =1;
                }
                break;
            case "b":
                if (collector.getBlock(output).getB() != -1)
                {
                    flag =1;
                }
                break;
            case "c":
                if (collector.getBlock(output).getC() != -1)
                {
                    flag =1;
                }
                break;
        }
        if(flag == 1)
        {
            alertAdd("Cannot connect", "Side is already specified!");
            return;
        }

        //Draw scheme
        collector.setConnection(input,output,as);
        this.scheme.drawScene(this.collector);
        drawLabel();

    }

    /**
     * Add specified data into block
     * @param event when button is pressed
     */
    public void addSide(ActionEvent event) {
        double a = -1,b = -1,c = -1;    //Default sides values
        int flag = 0;                   //When error occurs flag is set to 1

        if (!(sideA.getText().equals(""))) //Set side A when is on input
        {
            a = Double.parseDouble(sideA.getText());
        }
        if (!(sideB.getText().equals(""))) //Set side B when is on input
        {
            b = Double.parseDouble(sideB.getText());
        }
        if (!(sideC.getText().equals(""))) //Set side C when is on input
        {
            c = Double.parseDouble(sideC.getText());
        }
        if (sideBlock.getText().equals("") || Integer.parseInt(sideBlock.getText()) < 0 || Integer.parseInt(sideBlock.getText())-1 > collector.getCounter())
        {
            alertAdd("Invalid block", "Adding to invalid block number!");
            return;
        }

        int blockNum = Integer.parseInt(sideBlock.getText())-1; //Get index of block
        AbstractBlock block = collector.getBlock(blockNum); //Get block

        //Check if side already exist
        if((a > 0 && block.getA() == 0) || (b > 0 && block.getB() == 0) || (c > 0 && block.getC() == 0))
        {
            alertAdd("Cannot add side", "Cannot add side!");
            return;
        }

        switch (collector.getBlock(blockNum).getObject())
        {
            case "Square":
                if (b == -1 && c == -1 && a > 0)
                {
                    this.collector.changeBlockValue(blockNum, "a", a);

                }
                else
                {
                    flag = 1;
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
                    if (c != -1)
                    {
                        flag = 1;
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
                default:
                    alertAdd("Cannot add data", "Cannot add data into block!");
                    return;


        }
        if (flag == 1)
        {
            alertAdd("Invalid side of block", "Adding data into invalid side of block!");
            return;
        }

        drawLabel();
    }

    /**
     * Reset whole scheme
     * @param event when button is pressed
     */
    public void resetScheme(ActionEvent event)
    {
        collector = new Collector();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Remove block from scheme
     * @param event when button is pressed
     */
    public void removeBlock(ActionEvent event)
    {
        //Check if block is number
        if (!(blockToRemove.getText().matches("[0-9]+")))
        {
            alertAdd("Wrong ports", "Fill all ports by numbers!");
            return;
        }

        //Check if block index is legit
        if (Integer.parseInt(blockToRemove.getText()) <= 0 || Integer.parseInt(blockToRemove.getText()) > collector.getCounter())
        {
            alertAdd("Invalid block", "Deleting to invalid block number!");
            return;
        }


        int index = Integer.parseInt(blockToRemove.getText())-1;    //Index of block
        int blockIndex = collector.getBlock(index).getOutput();     //Block

        if (collector.getBlock(index).getOutput() != -1)
        {
            collector.getBlock(blockIndex).removeBlock();
        }

        //When there is input delete all outputs on indexes of blocks of input ports
        if (collector.getBlock(index).getMaxInput() != -1)
        {
            ArrayList<Integer> port = collector.getBlock(index).getInputArray();
            for (int i = 1; i< port.size(); i++)
            {
                collector.getBlock(port.get(i)).setOutput(-1);

            }
        }

        collector.delete(index); //Delete block

        //Draw scheme
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Reset all blocks to default values
     * @param event when button is pressed
     */
    public void resetBlocks(ActionEvent event)
    {
        collector.reset();
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Remove connection of specified block
     * @param event when button is pressed
     */
    public void removeConnection(ActionEvent event)
    {
        //Check if block is number
        if (!(outputDelete.getText().matches("[0-9]+")))
        {
            alertAdd("Wrong port", "Fill port by number!");
            return;
        }

        //Check if block index is legit
        if (Integer.parseInt(outputDelete.getText()) <= 0 || Integer.parseInt(outputDelete.getText()) > collector.getCounter())
        {
            alertAdd("Invalid block", "Deleting invalid block number!");
            return;
        }

        int blockNum = Integer.parseInt(outputDelete.getText())-1; //Get index of block

        //When there is no output
        if (collector.getBlock(blockNum).getOutput() == -1)
        {
            alertAdd("Nothing to delete", "No connection to delete!");
            return;

        }

        int index = collector.getBlock(blockNum).getOutput();   //Index of output block

        collector.getBlock(index).removeInput(blockNum);
        collector.getBlock(index).removeBlock();
        collector.getBlock(blockNum).setOutput(-1);

        //Draw scheme
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Execute operations step by step
     * @param event when button is pressed
     * @return value 1 when there is nothing more to execute
     */
    public int nextStep(ActionEvent event){
        AbstractBlock block;    //Block
        int flag = 0;           //When error occurs flag is set to 1

        for (int i = 0; i<collector.getCounter(); i++)
        {
            block = collector.getBlock(i);

            //Check if all values are set
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
                return 1;
            }
        }

        this.collector.next(); //Next step

        //Draw scene
        this.scheme.drawScene(this.collector);
        drawLabel();
        return 0;
    }

    /**
     * Save scheme into specified folder with specified name
     * @param event when menu button is pressed
     * @throws IOException when there is no file
     */
    public void saveFile(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(null);

        if(selectedFile != null)
        {
            this.collector.save(selectedFile);
            this.scheme = new DrawScheme();
            this.scheme.drawScene(this.collector);
            drawLabel();
        }
    }

    /**
     * Loads scheme in specified folder with specified name
     * @param event when menu button is pressed
     * @throws IOException when there is no file
     * @throws ClassNotFoundException class doesn't exist
     */
    public void openFile(ActionEvent event) throws IOException, ClassNotFoundException {
        FileChooser fc = new FileChooser();
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

    /**
     * Remove specified data from block
     * @param event when button is pressed
     */
    public void dataToRemove(ActionEvent event)
    {

        //Check if block is number
        if (!(dataBlockToRemove.getText().matches("[0-9]+")))
        {
            alertAdd("Wrong port", "Fill port by number!");
            return;
        }

        //Check if block index is legit
        if (Integer.parseInt(dataBlockToRemove.getText()) <= 0 || Integer.parseInt(dataBlockToRemove.getText()) > collector.getCounter())
        {
            alertAdd("Invalid block", "Deleting invalid block number!");
            return;
        }

        int index = Integer.parseInt(dataBlockToRemove.getText())-1; //Index of block

        //Check if side is set
        if (sideToRemove.getValue() == null)
        {
            alertAdd("Missing side", "Please specify side!");
            return;
        }

        String as = sideToRemove.getValue();                //Get value of as side
        AbstractBlock block = collector.getBlock(index);    //Get block
        int flag =0;                                        //Flag is set to 1 when error ocurs

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
                break;
            case "b":
                if (block.getB() == 0)
                {
                    flag = 1;
                }
                else if (block.getObject().equals("Square"))
                {
                    flag = 1;
                }
                else
                {
                    collector.getBlock(index).setB(-1);
                }
                break;
            case "c":
                if (block.getC() == 0)
                {
                    flag = 1;
                }
                else if (block.getObject().equals("Square") || block.getObject().equals("Rectangle"))
                {
                    flag = 1;
                }
                else
                {
                    collector.getBlock(index).setC(-1);
                }
                break;
        }

        if (flag == 1)
        {
            alertAdd("Cannot be removed", "Side cannot be removed!");
            return;
        }

        //Draw scene
        this.scheme.drawScene(this.collector);
        drawLabel();
    }

    /**
     * Delete mouse shown vale
     */
    public void mouseDeleteValue()
    {
        mouseTextLab.setText("   Value of connection is: ");
    }

    /**
     * Show connection value
     */
    public void mouseShowValue()
    {
        setMouseText(0);
    }

    /**
     * Show connection value
     */
    public void mouseShowValue2()
    {
        setMouseText(1);
    }

    /**
     * Show connection value
     */
    public void mouseShowValue3()
    {
        setMouseText(2);
    }

    /**
     * Show connection value
     */
    public void mouseShowValue4()
    {
        setMouseText(3);
    }

    /**
     * Show connection value
     */
    public void mouseShowValue5()
    {
        setMouseText(4);
    }

    /**
     * Load object into list
     */
    private void loadObjects()
    {
        objectList.removeAll();
        String a = "Square";
        String b = "Rectangle";
        String c = "Triangle";
        objectList.addAll(a,b,c);
        objectAdd.getItems().addAll(objectList);
    }

    /**
     * Load operations into list
     */
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

    /**
     * Load sides into list
     */
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

    /**
     * Show allert banner
     * @param title title of banner
     * @param header header of banner
     */
    private void alertAdd(String title, String header)
    {
        Alert a =  new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setTitle(title);
        a.showAndWait();
    }

    /**
     * Show information banner
     * @param title title of banner
     * @param header header of banner
     */
    private void informationAdd(String title, String header)
    {
        Alert i =  new Alert(Alert.AlertType.INFORMATION);
        i.setTitle(title);
        i.setHeaderText(header);
        i.setTitle(title);
        i.showAndWait();
    }

    /**
     * Add data into block on specified side
     */
    private void addData()
    {
        AbstractBlock block;    //Block
        String blockId;         //Id of block
        String outputValue ;    //Output result

        String outputText = ""; //

        for (int i = 0; i <  this.collector.getCounter(); i++)
        {
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


    /**
     * Draw ascii representation of scheme
     */
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

    /**
     * Show value of connection
     * @param index index of connection
     */
    private void setMouseText(int index)
    {
        if (collector.getCounter() > index && collector.getBlock(index).getOutput() != -1)
        {
            String str = Double.toString(collector.getBlock(index).getOutputResult());
            mouseTextLab.setText("   Value of connection is: " +str);
        }
    }
}
