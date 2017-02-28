package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.*;

public class Controller{
    private int[] arr = new int[10];
    @FXML private Label label;
    @FXML private TextField text;
    @FXML private TextField text1;
    private int number;
    private int i=0;

    public void onClick(){
        try{
                number = Integer.parseInt(text.getText());
                arr[i]=number;
                text.setText("");
                label.setText(label.getText()+number+" ");
                i++;
                text.setFocusTraversable(true);

        }catch (InputMismatchException e){
            label.setText("This is not a number");
            text.setText(e.toString());
        }catch (IndexOutOfBoundsException e){
            label.setText("Number is not valid");
            text.setText(e.toString());
        }catch (Exception e){
            label.setText("Something went wrong");
            text.setText(e.toString());
        }
    }
}
