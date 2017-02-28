package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML private TextField idText;
    @FXML private TextField timeText;
    @FXML private TextArea outList;
    Path path = Paths.get("CarList.txt");
    public void searchScene(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Scene currScene = node.getScene();
        Stage stage = (Stage) currScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void enteringScene(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Scene currScene = node.getScene();
        Stage stage = (Stage) currScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void exitBtn(){
        System.exit(0);
    }
    public void enterCar(){
        ArrayList<String> cars = new ArrayList<>();
        try{
            if (Files.exists(path)) {
                cars.add(idText.getText()+" "+ timeText.getText());
                Files.write(path,cars, StandardOpenOption.APPEND);
            }
            else {
                cars.add(idText.getText()+" "+ timeText.getText());
                Files.write(path,cars,StandardOpenOption.CREATE);
            }
        } catch (Exception e) {
            outList.setText(e.toString());
        }
    }
    public void readList(){
        outList.clear();
        try{
            if (Files.exists(path)) {
                List<String> cars = Files.readAllLines(path);
                for(String line: cars){
                    outList.appendText(line+"\n");
                }
            } else {
                outList.setText("List is empty");
            }
        }catch (Exception e){
                outList.setText(e.toString());
        }
    }
}
