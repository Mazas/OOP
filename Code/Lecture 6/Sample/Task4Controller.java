package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 * Created by ivana on 3/19/2017.
 */
public class Task4Controller extends Controller {
    @FXML private Canvas canvas;
    public void draw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Paint.valueOf("red"));
        //roof
        gc.strokeLine(200,200,300,200);
        //back
        gc.strokeLine(100,250,150,250);
        //front
        gc.strokeLine(350,250,400,250);
        //windows
        gc.strokeLine(150,250,200,200);
        gc.strokeLine(300,200,350,250);
        //vback
        gc.strokeLine(100,250,100,300);
        //vfront
        gc.strokeLine(400,250,400,300);
        //bottom
        gc.strokeLine(100,300,400,300);
        //wheels
        gc.strokeOval(150,305,50,50);
        gc.strokeOval(300,305,50,50);
        // filled windows
        gc.setFill(Paint.valueOf("blue"));
        double[] xpoints ={255,295,335,255};
        double[] ypoints={205,205,250,250};
        gc.fillPolygon(xpoints,ypoints,4);

    }
}
