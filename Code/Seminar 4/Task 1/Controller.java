package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private MyArrayList<Item> list = new MyArrayList<>();
    @FXML private TextField name;
    @FXML private TextField amount;
    @FXML private TextArea listView;
    private Path path = Paths.get("List.bin");

    public void viewList(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Scene currScene = node.getScene();
        Stage stage = (Stage) currScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        importList();
    }
    public void enterItems(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Scene currScene = node.getScene();
        Stage stage = (Stage) currScene.getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public void okBtn(){
        try{
            if (name.getText().equals("")){
                throw new Exception("Name cannot be empty");
            }
            if (amount.getText().equals("")){
                throw new Exception("Amount cannot be empty");
            }
            list.add(new Item(name.getText(),Integer.parseInt(amount.getText())));
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(list);
            name.setText("");
            amount.setText("");
        } catch (Exception e){
            if(e.getClass()==NumberFormatException.class){
                showError(new Exception("Amount should be in digits"));
            }else {
                showError(e);
            }
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Files.exists(path)){
            importList();
        }
    }
    private void importList(){
        try{
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path));
            list=(MyArrayList<Item>)in.readObject();
            listView.setText(list.toString());
            System.out.println(list);
        }catch (Exception e){
            if (e.getClass()!=NullPointerException.class){
                showError(e);
            }
        }
    }
    public void closeBtn(){
        System.exit(0);
    }
    private void showError(Exception e){
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Something went wrong");
        error.setContentText(e.getMessage());
        System.out.print(e.getLocalizedMessage());
        error.showAndWait();
    }

    public void clearBtn(){
        list.clear();
        listView.clear();
        try {
            Files.delete(path);
        }catch (Exception e){
            showError(e);
        }
    }
}
