package sample;

/**
 * Created by Mazas on 3/22/2017.
 */
public class Student extends Person{
    Student(String name, int age) {
        super(name, age);
    }
    public boolean isStudent(){
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+" is Student";
    }
}
