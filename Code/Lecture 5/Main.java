package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter name:");
        String name = in.next() + ":";
        System.out.println("Enter age:");
        String age = in.next() + ":";
        String ages;
        String names;
        try {
            Path path = Paths.get("Task4.txt");
            if (Files.exists(path)) {
                Scanner read = new Scanner(path);
                names = read.nextLine();
                ages = read.nextLine();
                list.add(names + name);
                list.add(ages + age);
                Files.write(path, list, StandardOpenOption.CREATE);
                printAll(names, ages);
            } else {
                list.add(name);
                list.add(age);
                Files.write(path, list, StandardOpenOption.CREATE);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    //task 5
    private static void printAll(String names, String ages) {
        String[] nameList = names.split(":");
        String[] ageList = ages.split(":");
        for (int i = 0; i < nameList.length; i++) {
            System.out.println(nameList[i] + " " + ageList[i]);
        }
    }
}
