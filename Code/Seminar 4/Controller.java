package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    @FXML private TextArea commands;
    private ArrayList<Direction> queue = new ArrayList<>();
    public void okBtn(){
        System.exit(0);
    }
    public void forwardBtn(){
        queue.add(Direction.FORWARD);
    }
    public void backBrn(){
        queue.add(Direction.BACK);
    }
    public void leftBtn(){
        queue.add(Direction.LEFT);
    }
    public void rightBtn(){
        queue.add(Direction.RIGHT);
    }
    public void showBtn(){
        commands.setText("");
        for(Direction d:queue){
            commands.appendText(d.toString()+"\n");
        }
    }
    public void clearBtn(){
        queue.clear();
        commands.setText("");
    }


}
