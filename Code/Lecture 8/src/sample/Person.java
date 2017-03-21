package sample;

import java.io.Serializable;

/**
 * Created by ivana on 3/21/2017.
 */
public class Person implements Serializable {
    private int age;
    private String name;
    Person(String name, int age){
        if(age>0) {
            this.age = age;
            this.name = name;
        }
    }
    @Override public String toString(){
        return "Name: "+name+" Age: "+age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
