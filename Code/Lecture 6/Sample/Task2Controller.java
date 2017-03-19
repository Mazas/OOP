package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task2Controller extends Controller{
    @FXML private Canvas canvas;
    public void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Paint.valueOf("red"));
        gc.fillRect(10,10,90,90);
        gc.setFill(Paint.valueOf("green"));
        gc.strokeRect(50,50,100,100);
        gc.strokeLine(10,10,50,50);
        gc.strokeLine(100,100,150,150);
        gc.strokeLine(10,100,50,150);
        gc.strokeLine(100,10,150,50);
        gc.setLineWidth(10);
        gc.setStroke(Paint.valueOf("blue"));
        gc.strokeOval(300,300,100,100);
        gc.setStroke(Paint.valueOf("yellow"));
        gc.strokeOval(350,350,100,100);
        gc.setStroke(Paint.valueOf("black"));
        gc.strokeOval(400,300,100,100);
        gc.setStroke(Paint.valueOf("green"));
        gc.strokeOval(450,350,100,100);
        gc.setStroke(Paint.valueOf("red"));
        gc.strokeOval(500,300,100,100);





    }
}

