package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;


/**
 * Created by Mazas on 3/22/2017.
 */
public class Conroller4 extends Controller {
    private MyGeneralObject obj;
    @FXML private Label label;
    @FXML private TextField age,name;
    @FXML private CheckBox isStudent;
    public void save() {
        try {
            if (isStudent.isSelected()) {
                obj = new MyGeneralObject(new Student(name.getText(), Integer.parseInt(age.getText())));
            } else {
                obj = new MyGeneralObject(new Person(name.getText(), Integer.parseInt(age.getText())));
            }
        } catch (InputMismatchException | NullPointerException e) {
            showError(e, "Not a valid number.");
        } catch (Exception e) {
            showError(e);
        }
    }
    public void read(){
        label.setText(obj.getObject().toString());
    }

}
