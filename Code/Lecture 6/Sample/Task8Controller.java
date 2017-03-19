package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task8Controller extends Controller implements Initializable{
    @FXML
    private AnchorPane pane;
    @FXML private Button btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane.setOnMouseClicked(this::draw);
    }
    private void draw(MouseEvent event){
        if(event.getSceneX()<btn.getLayoutX()||event.getSceneY()<btn.getLayoutY()){
            Circle c = new Circle(20, Paint.valueOf("red"));
            c.setCenterX(event.getSceneX());
            c.setCenterY(event.getSceneY());
            pane.getChildren().add(c);
        }
    }
}
