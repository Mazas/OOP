package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Stack;

public class Controller {
    @FXML private TextField entry;
    @FXML private Label revLabel;
    public void closeBtn(){
        System.exit(0);
    }
    public void okBtn(){
        Stack<Character> stack = new Stack<>();
        String result="";
        char[] chars = entry.getText().toCharArray();
        for (char a: chars){
            stack.push(a);
        }
        while (!stack.empty()){
            result=result+stack.pop();
        }
        revLabel.setText(result);
        if(revLabel.getText().equalsIgnoreCase("")){
            revLabel.setText("Write a word or a phrase to reverse.");
        }
    }
}
