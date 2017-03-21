package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller1 extends Controller {
    @FXML private TextField iEntry,dEntry,sEntry;
    private Path path1 = Paths.get("int");
    private Path path2 = Paths.get("double");
    private Path path3 = Paths.get("string");
    public void read(){
        try {
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path1));
            iEntry.setText(String.valueOf(in.readInt()));
            in.close();
            in = new ObjectInputStream(Files.newInputStream(path2));
            dEntry.setText(String.valueOf(in.readDouble()));
            in.close();
            in = new ObjectInputStream(Files.newInputStream(path3));
            sEntry.setText(in.readUTF());
            in.close();
        }catch (EOFException e){
            //there has to be an exception anyway
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
        try {
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path1));
            out.writeInt(Integer.parseInt(iEntry.getText()));
            out.close();
            out = new ObjectOutputStream(Files.newOutputStream(path2));
            out.writeDouble(Double.parseDouble(dEntry.getText()));
            out.close();
            out = new ObjectOutputStream(Files.newOutputStream(path3));
            out.writeUTF(sEntry.getText());
            out.close();
            iEntry.setText("");
            dEntry.setText("");
            sEntry.setText("");
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
