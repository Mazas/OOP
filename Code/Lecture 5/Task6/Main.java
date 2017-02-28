package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *Object serialization for reading and writing. Creates file called person.bin, writes in it and reads from it
 */
public class Main {

    public static void main(String[] args) {
        Person tadas = new Person("Tadas", "123456-7890", 23);
        ObjectOutputStream out;
        try {
            Path path = Paths.get("person.bin");
            out=new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(tadas);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        read(Paths.get("person.bin"));
    }
    private static void read(Path path){
        ObjectInputStream in;
        try{
            in=new ObjectInputStream(Files.newInputStream(path));
            Person person= (Person) in.readObject();
            System.out.println(person.toString());
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
