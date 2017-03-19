package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Controller {
    @FXML private Slider slider;
    @FXML private Label label;
    public void handle(){
        slider.setMax(10);
        slider.setSnapToTicks(true);
        slider.setMajorTickUnit(2);
        label.setText(String.valueOf(slider.getValue()));
    }
}
