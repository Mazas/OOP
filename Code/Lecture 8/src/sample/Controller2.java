package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller2 extends Controller {
    private List<String> names;
    @FXML private Label label;
    @FXML private TextField index;
    private Path path = Paths.get("names.txt");
    public void read() {
        try {
            names = Files.readAllLines(path);
            label.setText(names.get(Integer.parseInt(index.getText())));
            index.setText("");
        } catch (FileNotFoundException e) {
            showError(e, "File not found.");
        } catch (IndexOutOfBoundsException e){
            showError(e, "Index out of bounds.");
        } catch (InputMismatchException | NumberFormatException e) {
            showError(e, "This is not a valid number");
        } catch (NullPointerException e) {
            showError(e, "Please enter a number");
        } catch (Exception e) {
            showError(e);
        }
    }
}
