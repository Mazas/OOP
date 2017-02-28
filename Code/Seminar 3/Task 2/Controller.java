package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML private TextField accNumber;
    @FXML private TextField deposit;
    @FXML private TextField name;
    @FXML private Label balance;
    private Path path = Paths.get("Account.bin");
    private Account acc;

    public void closeBtn(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Files.exists(path)){
            readAcc();
            balance.setText(Double.toString(acc.getBalance()));
            deposit.setText("0");
            name.setText(acc.getName());
            accNumber.setText(acc.getAccNumber());
        } else {
            acc = new Account("Name","Account Number");
            balance.setText("0");
            deposit.setText("0");
            name.setText("");
            accNumber.setText("");
        }
    }
    public void depositBtn(){
        try {
            acc.deposit(Double.parseDouble(deposit.getText()));
            balance.setText(Double.toString(acc.getBalance()));
        }catch (Exception e){
            balance.setText(e.toString());
        }
    }

    public void okBtn(){
        ObjectOutputStream out;
        try{
            out = new ObjectOutputStream(Files.newOutputStream(path));
            if (Files.exists(path)){
                readAcc();
                acc.setName(name.getText());
                acc.setAccNumber(accNumber.getText());
                acc.deposit(Double.parseDouble(deposit.getText()));
                out.writeObject(acc);
            } else {
                acc = new Account(name.getText(),accNumber.getText());
                acc.deposit(Double.parseDouble(deposit.getText()));
                out.writeObject(acc);
            }
            balance.setText(Double.toString(acc.getBalance()));
        } catch (Exception e){
            balance.setText(e.toString());
        }
    }
    private void readAcc(){
        ObjectInputStream in;
        try{
            in=new ObjectInputStream(Files.newInputStream(path));
            acc = (Account) in.readObject();
        }catch (IOException |ClassNotFoundException e){
            /*
            catch (IOException|ClassNotFoundException|Exception e){
            IDE doesn't allow multiCatch if one exception is a subclass/superclass of another
            in this case Exception is a superclass of all others
             */
        }
    }
}
