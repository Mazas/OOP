package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML private Label label;
    @FXML private TextField integer;
    @FXML private TextField string;
    public void writeBtn(){
        try {
            Path path = Paths.get("Task2.txt");
            ArrayList<String> list =new ArrayList<>();
            list.add(string.getText());
            if (Files.exists(path)) {
                Files.write(path,list, StandardOpenOption.APPEND);
                list.clear();
            } else{
                Files.write(path,list,StandardOpenOption.CREATE);
            }
        } catch (Exception e){
            label.setText(e.toString());
        }
    }
    public void readBtn(){
        try{
            Path path = Paths.get("Task2.txt");
            List<String> list = Files.readAllLines(path);
            label.setText(list.get(Integer.parseInt(integer.getText())));
        } catch (Exception e){
            label.setText(e.toString());
        }
    }
}
