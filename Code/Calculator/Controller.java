package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    private String action;
    private enum Action{

        DIVIDE("/"),
        MULTIPLY("*"),
        SUBTRACT("-"),
        ADD("+");
        private final String act;
        Action(String act){
            this.act=act;
        }
        private String getAct(){
            return act;
        }
    }
    private double firstNum=0;
    private double secondNum=0;
    @FXML private Label label;
    @FXML private Label num1;
    @FXML private Label num2;
    String result;
    public void zero(){
        label.setText(label.getText()+"0");
    }
    public void one(){
        label.setText(label.getText()+"1");
    }
    public void two(){
        label.setText(label.getText()+"2");
    }
    public void three(){
        label.setText(label.getText()+"3");
    }
    public void four(){
        label.setText(label.getText()+"4");
    }
    public void five(){
        label.setText(label.getText()+"5");
    }
    public void six(){
        label.setText(label.getText()+"6");
    }
    public void seven(){
        label.setText(label.getText()+"7");
    }
    public void eight(){
        label.setText(label.getText()+"8");
    }
    public void nine(){
        label.setText(label.getText()+"9");
    }
    public void dot(){
        label.setText(label.getText()+".");
    }
    public void multiply() {
        if (action == null) {
            action = Action.MULTIPLY.getAct();
            firstNum = Double.parseDouble(label.getText());
            label.setText("");
            num1.setText(""+firstNum);
        } else {
            secondNum=Double.parseDouble(label.getText());
            num2.setText(""+secondNum);
            //calculate();
        }
    }
    public void divide(){
        if (action == null||secondNum==0) {
            action = Action.DIVIDE.getAct();
            firstNum = Double.parseDouble(label.getText());
            label.setText("");
            num1.setText(""+firstNum);

        } else {
            secondNum=Double.parseDouble(label.getText());
            num2.setText(""+secondNum);
            //calculate();
        }
    }
    public void add(){
        if (action == null) {
            action = Action.ADD.getAct();
            firstNum = Double.parseDouble(label.getText());
            label.setText("");
            num1.setText(""+firstNum);

        } else {
            secondNum=Double.parseDouble(label.getText());
            num2.setText(""+secondNum);
            //calculate();
        }
    }
    public void subtract(){
        if (action == null) {
            action = Action.SUBTRACT.getAct();
            firstNum = Double.parseDouble(label.getText());
            label.setText("");
            num1.setText(""+firstNum);

        } else {
            secondNum=Double.parseDouble(label.getText());
            num2.setText(""+secondNum);
            //calculate();
        }
    }
    private double memory=0;
    public void setMemory(){
        if (action==null&&secondNum==0){
            memory=Double.parseDouble(label.getText());
        }else if(action!=null&&memory!=0){
            secondNum=memory;
            label.setText(""+secondNum);
        }
    }
    public void clearMem(){
        memory=0;
    }
    public void clearAll(){
        //memory=0;
        firstNum=0;
        secondNum=0;
        action=null;
        label.setText(null);
    }
    public void clear(){
        label.setText(null);
        secondNum=0;
    }
    public void equals(){
        if (label.getText()!=null&&action!=null) {
            secondNum = Double.parseDouble(label.getText());
            num2.setText(""+secondNum);
            calculate();
        }
    }
    private void calculate(){
        switch (action){
            case "*":
                firstNum*=secondNum;
                action=null;
                secondNum=0;
                label.setText(""+firstNum);
                break;
            case "/":
                if (secondNum==0){
                    break;
                }
                firstNum/=secondNum;
                action=null;
                label.setText(""+firstNum);
                secondNum=0;
                break;
            case"+":
                firstNum+=secondNum;
                action=null;
                label.setText(""+firstNum);
                secondNum=0;
                break;
            case "-":
                firstNum-=secondNum;
                action=null;
                label.setText(""+firstNum);
                secondNum=0;
                break;
            default:
                break;
        }
        label.setText(label.getText().trim());
        num1.setText(""+firstNum);
        num2.setText(""+secondNum);
    }

}
