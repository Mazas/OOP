package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task3Controller extends Controller implements Initializable{
    @FXML private Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       button.setStyle("-fx-background-color:green;");
    }
}
