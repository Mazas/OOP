package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField text;

    public void button(ActionEvent e) {
        try {
            Singleton.getInstance().setMessage(text.getText());
            Node node = (Node) e.getSource();
            Scene scene = node.getScene();
            Stage stage = (Stage) scene.getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();

        } catch (Exception ex) {
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setHeaderText("somethingwent wrong");
            err.showAndWait();
        }
    }
}