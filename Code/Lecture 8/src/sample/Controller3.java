package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller3 extends Controller {
    @FXML private TextField n1,n2,result;
    private Path path1 = Paths.get("n1");
    private Path path2 = Paths.get("n2");
    private Path path3 = Paths.get("result");
    public void read(){
        try{
            n1.setText(Files.readAllLines(path1).get(0));
            n2.setText(Files.readAllLines(path2).get(0));
            result.setText(Files.readAllLines(path3).get(0));
        }catch (FileNotFoundException e){
            showError(e,"File not found.");
        }catch (InputMismatchException|NumberFormatException e){
            showError(e, "This is not a valid number");
        }catch (NullPointerException e){
            showError(e,"Please enter a number");
        }catch (Exception e) {
            showError(e);
        }
    }
    public void write(){
        ArrayList<String> writable = new ArrayList<>();
        try {
            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());
            writable.add(n1.getText());
            Files.write(path1,writable, StandardOpenOption.CREATE);
            writable.clear();
            writable.add(n2.getText());
            Files.write(path2,writable,StandardOpenOption.CREATE);
            writable.clear();
            writable.add(String.valueOf(a*b));
            Files.write(path3,writable,StandardOpenOption.CREATE);
        }catch (FileNotFoundException e){
            showError(e,"File not found.");
        }catch (InputMismatchException|NumberFormatException e){
            showError(e, "This is not a valid number");
        }catch (NullPointerException e){
            showError(e,"Please enter a number");
        }catch (Exception e){
            showError(e);
        }
    }
}
