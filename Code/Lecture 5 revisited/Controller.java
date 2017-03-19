package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Controller {
    public void button(javafx.event.ActionEvent event){
        try{
            Node node = (Node) event.getSource();
            Scene scene = node.getScene();
            Stage stage = (Stage) scene.getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();

        }
        catch (Exception e){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setHeaderText("Something went wrong");
            err.showAndWait();
        }
    }
}
