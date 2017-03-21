package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller6 extends Controller {
    @FXML private TextField name,age;
    Path path = Paths.get("task6.bin");
    public void write(){
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))){
            Person person = new Person(name.getText(), Integer.parseInt(age.getText()));
            out.writeObject(person);
            name.setText("");
            age.setText("");
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
    public void read(){
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            Person person = (Person) in.readObject();
            name.setText(person.getName());
            age.setText(String.valueOf(person.getAge()));
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
}
