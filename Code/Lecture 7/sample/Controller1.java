package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by ivana on 3/20/2017.
 */
public class Controller1 extends Controller {
    @FXML private Label result;
    @FXML private TextField first;
    @FXML private TextField second;
    public void calculate(){
        try{
            result.setText(String.valueOf(Double.parseDouble(first.getText())+Double.parseDouble(second.getText())));
        }catch (NumberFormatException e){
            showError(e,"This is not a legit number");
        }catch (Exception  e){
            showError(e);
        }finally {
            first.setText("");
            second.setText("");
        }
    }
}
