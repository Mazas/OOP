package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by ivana on 3/19/2017.
 */
public class Singleton {
    private static Singleton instance = null;
    private SimpleStringProperty message = new SimpleStringProperty();
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }

    public static void setInstance(Singleton instance) {
        Singleton.instance = instance;
    }

    public String getMessage() {
        return message.get();
    }

    public SimpleStringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }
}
