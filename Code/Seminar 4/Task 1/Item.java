package sample;


import java.io.Serializable;

/**
 * Created by ivana on 3/12/2017.
 */
public class Item implements Serializable{
    private String name;
    private int amount;
    public Item(String name,int amount){
        this.name=name;
        this.amount=amount;
    }
    @Override
    public String toString(){
        return name+" "+String.valueOf(amount);
    }
}
