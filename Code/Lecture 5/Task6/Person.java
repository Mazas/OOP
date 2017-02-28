package com.company;

import java.io.Serializable;

/**
 * Created by ivana on 2/23/2017.
 */
public class Person implements Serializable{
    private String name;
    private int age;
    private String ssn;
    Person(String name, String ssn, int age){
        this.name=name;
        this.age=age;
        this.ssn=ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    @Override
    public String toString(){
        return name+" "+age+" "+ssn;
    }
}
