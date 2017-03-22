package sample;

/**
 * Created by Mazas on 3/22/2017.
 */
public class Person implements Comparable {
    private String name;
    private int age;
    Person(String name, int age){
        this.name=name;
        if (age>0){
            this.age=age;
        }else {
            this.age=0;
        }
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
        if (age>0) {
            this.age = age;
        }
    }
    public String toString(){
        return name+" "+age;
    }

    @Override
    public int compareTo(Object o) {
        return ((Person)o).getAge()-age;
    }
}
