package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * Created by Mazas on 3/22/2017.
 */
public class Controller implements Initializable {
    //Path for error logging
    private final Path path = Paths.get("src" + File.separator + "sample" + File.separator + "ErrorLog.txt");

    //handle scene loader
    public void changeTask(ActionEvent event) {
        try {
            String[] task = event.getSource().toString().split("'");
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(task[1] + ".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (FileNotFoundException | LoadException e) {
            showError(e, "File not found");
        } catch (Exception e) {
            showError(e);
        }
    }

    //method to go back to main menu
    public void back(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (FileNotFoundException | LoadException e) {
            showError(e, "File not found");
        } catch (Exception e) {
            showError(e);
        }
    }

    @Override
    //make the log file
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (FileNotFoundException | NullPointerException e) {
            showError(e, "File not found");
        } catch (Exception e) {
            showError(e);
        }
    }

    //show a general error
    public void showError(Exception e) {
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setContentText(e.getMessage());
        err.setHeaderText("Something went wrong.");
        err.setTitle("Oops!");
        try{
            ArrayList<String> error = new ArrayList<>();
            error.add(new Timestamp(System.currentTimeMillis())+":"+e.toString()+":"+e.getMessage());
            Files.write(path,error, StandardOpenOption.APPEND);
        }catch (Exception e1){
            //do nothing for now
        }
        err.showAndWait();
    }

    //show specific error message
    public void showError(Exception e, String message) {
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setContentText(e.getMessage());
        err.setHeaderText(message);
        err.setTitle("Oops!");
        try{
            ArrayList<String> error = new ArrayList<>();
            error.add(new Timestamp(System.currentTimeMillis())+":"+e.toString()+":"+message);
            Files.write(path,error, StandardOpenOption.APPEND);
        }catch (Exception e1){
            //do nothing for now
        }
        err.showAndWait();
    }
    //close
    public void close(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }
}
