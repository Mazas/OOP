package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

import java.security.SecureRandom;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task5Controller extends Controller{
    SecureRandom random = new SecureRandom();
    @FXML private Canvas canvas;
    int x,y;
    Double maxX,maxY;
    public void drawRandom(KeyEvent event){
        GraphicsContext gc=canvas.getGraphicsContext2D();
        maxX=canvas.getWidth();
        maxY=canvas.getHeight();
        x=random.nextInt(maxX.intValue());
        y=random.nextInt(maxY.intValue());
        if (event.getCode().equals(KeyCode.E)){
            gc.setFill(Paint.valueOf("blue"));
            gc.fillRect(x,y,20,20);
        } else if(event.getCode().equals(KeyCode.W)){
            gc.setFill(Paint.valueOf("red"));
            gc.fillOval(x,y,20,20);
        }
    }
}
