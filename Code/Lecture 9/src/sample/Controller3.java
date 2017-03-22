package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Mazas on 3/22/2017.
 */
public class Controller3 extends Controller{
    @FXML
    private TextField entry;
    @FXML private Label label;
    public void check() {
        try {
            MyGeneralObject object = new MyGeneralObject(Integer.parseInt(entry.getText()));
            label.setText(String.valueOf(object.isInteger()));
        }catch (Exception e) {
            MyGeneralObject object = new MyGeneralObject(entry.getText());
            label.setText(String.valueOf(object.isInteger()));
        }
        entry.setText("");
    }
}
