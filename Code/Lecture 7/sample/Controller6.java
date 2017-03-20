package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by ivana on 3/20/2017.
 */
public class Controller6 extends Controller {
    @FXML
    private Label result;
    @FXML private TextField first;
    @FXML private TextField second;
    public void calculate(){
        try{
            int a = Integer.parseInt(first.getText());
            int b = Integer.parseInt(second.getText());
            result.setText(divide(a,b));
        }catch (NumberFormatException e){
            showError(e,"This is not a legit number.");
        }catch (ArithmeticException ae){
            showError(ae,"Can not divide by zero.");
        }catch (Exception  e){
            showError(e);
        }finally {
            first.setText("");
            second.setText("");
        }
    }
    private String divide(int a, int b){
        assert (b>0||b<0);
        return String.valueOf(a/b);
    }
}
