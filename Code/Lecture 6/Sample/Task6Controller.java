package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.net.URL;

import java.util.ResourceBundle;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task6Controller extends Controller implements Initializable{
    @FXML private Button button;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(event -> {
            Timeline tl = new Timeline();
            tl.setCycleCount(2);
            tl.setAutoReverse(true);
            KeyValue kv = new KeyValue(button.scaleXProperty(),2);
            KeyValue kv2 = new KeyValue(button.scaleYProperty(),2);
            KeyFrame kf = new KeyFrame(Duration.millis(500),kv,kv2);
            tl.getKeyFrames().add(kf);
            tl.play();
        });
    }
}
