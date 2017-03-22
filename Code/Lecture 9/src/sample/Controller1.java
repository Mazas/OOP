package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;


/**
 * Created by Mazas on 3/22/2017.
 */
public class Controller1 extends Controller{
    @FXML
    private TextField number1, number2;
    @FXML private Label result;
    public void compare(){
        MyGeneralObject<Double> num1=new MyGeneralObject<>();
        MyGeneralObject<Double> num2=new MyGeneralObject<>();
        try {

            num1.setObject(Double.parseDouble(number1.getText()));
            num2.setObject(Double.parseDouble(number2.getText()));
        }catch (InputMismatchException|NullPointerException e){
            showError(e,"Not a valid number.");
        }catch (Exception e){
            showError(e);
        }
        number1.setText("");
        number2.setText("");
        result.setText(String.valueOf(num1.smallest(num2.getObject())));
    }
    public void isEqual(){
        MyGeneralObject<Double> num1=new MyGeneralObject<>();
        MyGeneralObject<Double> num2=new MyGeneralObject<>();
        try {

            num1.setObject(Double.parseDouble(number1.getText()));
            num2.setObject(Double.parseDouble(number2.getText()));
        }catch (InputMismatchException|NullPointerException e){
            showError(e,"Not a number.");
        }catch (Exception e){
            showError(e);
        }
        number1.setText("");
        number2.setText("");
        result.setText(String.valueOf(num1.isEqual(num2.getObject())));
    }

}
