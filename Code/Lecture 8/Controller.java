package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private final File dir = new File("src"+File.separator+"Logs");
    private final Path path = Paths.get(dir.getPath()+File.separator+"ErrorLog.txt");
    private Date date = new Date();

    public void loadTask(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            String[] arr = event.getSource().toString().split("'");
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(arr[1]+".fxml"));
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (NullPointerException|FileNotFoundException|LoadException e){
            showError(e,"File not Found.");
        }catch (Exception e){
            showError(e);
        }
    }



    public void close(ActionEvent e){
        Node node = (Node)e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    void showError(Exception e,String string){
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setHeaderText(string);
        err.setTitle("Oops!");
        err.setContentText(e.getMessage());
        try {
                ArrayList<String> list = new ArrayList<>();
                list.add(new Timestamp(System.currentTimeMillis())+" "+e.toString() + " " + e.getMessage()+" "+string);
            if (Files.exists(path)) {
                Files.write(path, list, StandardOpenOption.APPEND);
            }else {
                Files.write(path, list, StandardOpenOption.CREATE);
            }
        }catch (Exception e1){
            showError(e1);
        }
        err.showAndWait();
    }

    void showError(Exception e){
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setHeaderText("Something went wrong.");
        err.setTitle("Oops!");
        err.setContentText(e.getMessage());
        try {
            ArrayList<String> list = new ArrayList<>();
            list.add(new Timestamp(System.currentTimeMillis())+" "+e.toString() + " " + e.getMessage());
            if (Files.exists(path)) {
                Files.write(path, list, StandardOpenOption.APPEND);
            }else {
                Files.write(path, list, StandardOpenOption.CREATE);
            }
        }catch (Exception e1){
            showError(e1);
        }
        err.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (!Files.exists(path)) {
                if (!dir.mkdirs()) {
                    throw new Exception("Could not create directory" + path);
                }
            }
        }catch (Exception e){
            showError(e);
        }
    }
    public void back(ActionEvent event){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (NullPointerException|FileNotFoundException|LoadException e){
            showError(e,"File not Found.");
        }catch (Exception e){
            showError(e);
        }
    }
}
