package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private CheckBox one;
    @FXML
    private CheckBox two;
    @FXML
    private CheckBox three;
    @FXML
    private CheckBox four;
    @FXML
    private CheckBox five;
    @FXML
    private CheckBox six;
    @FXML
    private CheckBox seven;
    @FXML
    private CheckBox eight;
    @FXML
    private Label value;
    private Path path = Paths.get("Byte.bin");

    private char[] labelText = {'0', '0', '0', '0', '0', '0', '0', '0'};

    public void handleOne() {
        value.setText("");
        if (one.isSelected()) {
            labelText[7] = '1';
        } else {
            labelText[7] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleTwo() {
        value.setText("");
        if (two.isSelected()) {
            labelText[6] = '1';
        } else {
            labelText[6] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleThree() {
        value.setText("");
        if (three.isSelected()) {
            labelText[5] = '1';
        } else {
            labelText[5] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleFour() {
        value.setText("");
        if (four.isSelected()) {
            labelText[4] = '1';
        } else {
            labelText[4] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleFive() {
        value.setText("");
        if (five.isSelected()) {
            labelText[3] = '1';
        } else {
            labelText[3] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleSix() {
        value.setText("");
        if (six.isSelected()) {
            labelText[2] = '1';
        } else {
            labelText[2] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleSeven() {
        value.setText("");
        if (seven.isSelected()) {
            labelText[1] = '1';
        } else {
            labelText[1] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void handleEight() {
        value.setText("");
        if (eight.isSelected()) {
            labelText[0] = '1';
        } else {
            labelText[0] = '0';
        }
        for (char aLabelText : labelText) {
            value.setText(value.getText() + aLabelText);
        }
    }

    public void okBtn() {
        try {
            value.setText("");
            String string = "";
            for (char aLabelText : labelText) {
                string+=aLabelText;
            }
            byte[] bytes = new byte[1];
            if (labelText[0] == '1') {
                string="0"+string.substring(1);
                bytes[0] = (byte)(Byte.parseByte(string, 2)^128);
                //System.out.print(bytes[0]);
            } else {
                bytes[0] = Byte.parseByte(string, 2);
            }
            Files.write(path,bytes);
            for (char c : labelText) {
                value.setText(value.getText() + c);
            }
        } catch (Exception e) {
            value.setText(e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Files.exists(path)) {
            try {
                value.setText("");
                byte[] bytes = Files.readAllBytes(path);
                String tmp = Integer.toBinaryString(Integer.parseInt(String.valueOf(bytes[0])));
                tmp = new StringBuilder(tmp).reverse().toString();
                while (tmp.length()<8){
                    tmp+="0";
                }if(tmp.length()!=32) {
                    //System.out.println(tmp+"\n"+tmp.length());
                    tmp = new StringBuilder(tmp.substring(0, 8)).reverse().toString();
                } else{
                    //System.out.println(tmp+"\n"+tmp.length());
                    tmp=new StringBuilder(tmp).reverse().toString().substring(24);
                }


                labelText = tmp.toCharArray();
                if (labelText[7] == '1') {
                    one.setSelected(true);
                }
                if (labelText[6] == '1') {
                    two.setSelected(true);
                }
                if (labelText[5] == '1') {
                    three.setSelected(true);
                }
                if (labelText[4] == '1') {
                    four.setSelected(true);
                }
                if (labelText[3] == '1') {
                    five.setSelected(true);
                }
                if (labelText[2] == '1') {
                    six.setSelected(true);
                }
                if (labelText[1] == '1') {
                    seven.setSelected(true);
                }
                if (labelText[0] == '1') {
                    eight.setSelected(true);
                }
                for (char c : labelText) {
                    value.setText(value.getText() + c);
                }
            } catch (Exception e) {
                value.setText(e.toString());
                e.printStackTrace();
            }
        } else {
            value.setText("00000000");
        }
    }

    public void closeBtn(){
        System.exit(0);
    }
    /*private static boolean[] boolFromByte(byte aByte) {
        boolean bs[] = new boolean[8];
        bs[0] = ((aByte & 0x01) !=0);
        bs[1] = ((aByte & 0x02) !=0);
        bs[2] = ((aByte & 0x04) !=0);
        bs[3] = ((aByte & 0x08) !=0);
        bs[4] = ((aByte & 0x10) !=0);
        bs[5] = ((aByte & 0x20) !=0);
        bs[6] = ((aByte & 0x40) !=0);
        bs[7] = ((aByte & 0x80) !=0);
        return bs;
    }*/
}
