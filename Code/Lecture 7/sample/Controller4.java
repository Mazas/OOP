package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

/**
 * Created by ivana on 3/20/2017.
 */
public class Controller4 extends Controller{
    @FXML private Label label;
    @FXML private TextField entry;
    private double[] array = new double[10];
    int i = 0;
    public void add(){
        try {
            array[i]=Double.parseDouble(entry.getText());
            label.setText(label.getText()+array[i]+" ");
            i++;
        }catch (InputMismatchException e){
            showError(e, "This is not a number.");
        }catch (NumberFormatException e){
            showError(e, "Enter a number please.");
        }catch (IndexOutOfBoundsException e){
            showError(e, "Array is full.");
        }catch (Exception e){
            showError(e);
        }
    }
}
