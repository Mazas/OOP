package home;

public class Main implements MyListener{

    public static void main(String[] args){
        Main self = new Main();
        MyTimer.Start(self,10,1);
    }

    @Override
    public void Notify(int timerID) {
        System.out.println("I am now notified by the timer!");
    }
}
