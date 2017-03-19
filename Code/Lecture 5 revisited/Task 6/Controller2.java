package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ivana on 3/19/2017.
 */
public class Controller2 implements Initializable{
    @FXML
    private Label label;
    public void btn(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setHeaderText("Something went wrong");
            err.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(Singleton.getInstance().getMessage());
    }
}
