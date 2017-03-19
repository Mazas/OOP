package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField a;
    @FXML private TextField b;
    @FXML private Label label;
    public void button(){
        try{
            label.setText(String.valueOf(Double.parseDouble(a.getText())+Double.parseDouble(b.getText())));
        }catch (Exception e){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setContentText("Something went wrong");
            err.showAndWait();
        }
    }
}
