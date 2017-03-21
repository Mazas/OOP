package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ivana on 3/21/2017.
 */
public class Controller4 extends Controller {
    Path path = Paths.get("t4_names.txt");
    @FXML
    private TextField name, age;

    public void write() {
            createFile();
        try (Scanner in = new Scanner(path)) {
            String names = in.nextLine();
            String ages = in.nextLine();
            names += name.getText();
            ages += age.getText();
            ArrayList<String> writable = new ArrayList<>();
            writable.add(names+":");
            writable.add(ages+":");
            Files.write(path, writable, StandardOpenOption.CREATE);
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

    private void createFile() {
        try {
            if (!Files.exists(path)) {
                ArrayList<String> writable = new ArrayList<>();
                writable.add("Names:");
                writable.add("Ages:");
                Files.write(path, writable, StandardOpenOption.CREATE);
            }
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
}
