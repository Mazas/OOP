package home;

/**
 * Created by ivana on 2/6/2017.
 */
public class MyTimer {
    public static void Start(MyListener listener, int seconds,int timerID){
        listener.Notify(timerID);
    }
}
