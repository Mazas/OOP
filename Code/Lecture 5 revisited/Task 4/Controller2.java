package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by ivana on 3/19/2017.
 */
public class Controller2 {
    public void btn(ActionEvent event){
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        }catch (Exception e){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setHeaderText("Something went wrong");
            err.showAndWait();
        }
    }
}
