package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

/**
 * Created by ivana on 3/20/2017.
 */
public class Controller5 extends Controller{
    @FXML private Label label;
    @FXML private TextField entry;
    private double[] array = new double[10];
    int i = 0;
    public void add(){
        try {
            array[i]=Double.parseDouble(entry.getText());
            label.setText(label.getText()+array[i]+" ");
            i++;
        }catch (InputMismatchException|IndexOutOfBoundsException|NullPointerException|NumberFormatException e){
            showError(e, "Something went wrong.");
        }catch (Exception e){
            showError(e);
        }
    }
}
