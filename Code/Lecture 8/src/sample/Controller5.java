package sample;

import com.sun.javafx.binding.StringFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller5 extends Controller4 {
    @FXML private ListView lv;
    private ObservableList<String> list = FXCollections.observableArrayList();
    public void read(){
        try (Scanner in = new Scanner(super.path)){
            String[] names = in.nextLine().split(":");
            String[] ages = in.nextLine().split(":");
            for (int i= 0;i<names.length;i++){
                list.add(String.format("%1$-10s %2$10s",names[i],ages[i]));
            }
            lv.setItems(list);
        } catch (FileNotFoundException | NoSuchFileException e) {
            showError(e, "File not found.");
        } catch (InputMismatchException | NumberFormatException e) {
            showError(e, "This is not a valid number");
        } catch (NullPointerException e) {
            showError(e, "Please enter a number");
        } catch (Exception e) {
            showError(e);
        }
    }
    @Override public void initialize(URL location, ResourceBundle resources) {

    }
}
