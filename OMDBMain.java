/*
 * Name:       Noah Lopez
 *
 * Course:     CSCI 13, Spring 2017
 *
 * Date:       5/6/18
 *
 * Filename:   OMDBMain.java
 *
 * Purpose:    Main for the final project
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OMDBMain extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("./OMDBView.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("CSCI-13 Final Project - Noah Lopez");
        stage.show();
    }
        
    public static void main(String[] args)
    {
        launch(args);
    }
}