package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by ivana on 3/20/2017.
 */
public class Controller3 extends Controller implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField entry;

    private ArrayList<String> myList;

    public void show() {
        try {
            int i = Integer.parseInt(entry.getText())-1;
            label.setText(myList.get(i));
        } catch (IndexOutOfBoundsException e) {
            showError(e,"Index Out Of Bounds!");
        } catch (Exception e) {
            showError(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myList = new ArrayList<>();
        myList.add("John");
        myList.add("Thomas");
        myList.add("Peter");
        myList.add("Natalie");
        myList.add("Cristina");
        myList.add("Anna");
    }
}
