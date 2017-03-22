package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

/**
 * Created by Mazas on 3/22/2017.
 */
public class Controller5 extends Controller {
    @FXML private TextField number1,number2;
    @FXML private Label result;
    public void show(){
        try {
            Generic<Integer, String> load = new Generic(Integer.parseInt(number1.getText()), number2.getText());
            result.setText(load.getObj1() + " " + load.getObj2());
        }catch (NullPointerException e){
            showError(e,"Enter something");
        }catch (InputMismatchException|NumberFormatException e){
            showError(e, "Enter an integer and a string");
        }catch (Exception e){
            showError(e);
        }
    }
}
