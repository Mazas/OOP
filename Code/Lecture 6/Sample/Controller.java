package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class Controller {
    public void changeTask(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            String task = event.getSource().toString();
            String[] arr = task.split("'");
            task = arr[1];
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(task + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setHeaderText("Something went wrong");
            err.setContentText(e.toString());
            err.setTitle("Oops");
            e.printStackTrace();
            err.showAndWait();
        }
    }

    public void goBack(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Task 1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            showError(e);
        }
    }

    private void showError(Exception e) {
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setHeaderText("Something went wrong");
        err.setContentText(e.toString());
        err.setTitle("Oops");
        err.showAndWait();
    }
}
