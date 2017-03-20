package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class Controller {
    //change scene according to what button was pressed
    public void changeScene(ActionEvent event){
            String[] arr = event.getSource().toString().split("'");
            String task;
            if (arr[1]!=null) {
                task = arr[1];
            }else {
                task="sample";
            }
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage)node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(task+".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (FileNotFoundException|NullPointerException|LoadException e){
            showError(e,"File \""+task+".fxml\" was not found!");
        }catch (Exception e){
            showError(e);

        }
    }
    //Code to show a nice error message
    public void showError(Exception e){
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setContentText(e.toString());
        err.setHeaderText(e.getMessage());
        err.setTitle("Oops!");
        e.printStackTrace();
        err.showAndWait();
    }
    //overide method to add string message
    public void showError(Exception e,String message){
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setContentText(e.toString());
        err.setHeaderText(message);
        err.setTitle("Oops!");
        err.showAndWait();
    }
    //public method to close the program
    public void  close(ActionEvent event){
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        stage.close();
    }
    //go back to main menu
    public void goBack(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root =loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (FileNotFoundException|NullPointerException e){
            showError(e,"File \"sample.fxml\" was not found!");
        } catch (Exception e){
            showError(e);
        }
    }
}
