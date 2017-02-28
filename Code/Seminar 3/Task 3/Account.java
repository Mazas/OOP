package sample;

import java.io.Serializable;

import static java.lang.Math.abs;

/**
 * Created by ivana on 2/27/2017.
 */
public class Account implements Serializable {
    private String name;
    private double balance;
    private String accNumber;
    Account(String name, String accNumber){
        this.name=name;
        this.accNumber=accNumber;
        balance=0;
    }
    public void deposit(double amount) {
        if (balance+amount>0) {
            balance += amount;
        }
    }
    public void setName(String name){
        if (name.equalsIgnoreCase("")||name.equalsIgnoreCase(null)){
            return;
        }
        this.name=name;
    }
    public void setAccNumber(String accNumber){
        if (accNumber.equalsIgnoreCase("")||accNumber.equalsIgnoreCase(null)){
            return;
        }
        this.accNumber=accNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    public String getAccNumber(){
        return accNumber;
    }
}
