package sample;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task7Controller extends Controller implements Initializable{
    @FXML private AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Rectangle rec = new Rectangle(50,50);
        pane.getChildren().add(rec);
        Line path = new Line(25,150,450,150);
        PathTransition pt = new PathTransition(Duration.millis(1500),path,rec);
        pt.setOnFinished(event -> {
            Button btn = new Button();
            btn.setOnAction(super::goBack);
            pane.getChildren().add(btn);
            btn.fireEvent(new ActionEvent());
        });
        pt.play();
    }
}
