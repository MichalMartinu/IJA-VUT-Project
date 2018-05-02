package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class of project.
 * @author Michal Martinu(xmarti78)
 * @author Vojtech Hromadka(xhroma13)
 * */
public class Main extends Application {

    /**
     * Starts program.
     * @param args Arguments of application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets scene of application
     * @param primaryStage Primary stage
     * */
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));


        primaryStage.setTitle("ASCII Block scheme maker");

        Scene scene = new Scene(root,  1000, 730);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
