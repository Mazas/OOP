package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        Path gPath = null;
        list.add(in.next());
        list.add(in.next());
        try {
            Path path = Paths.get("Task3.txt");
            gPath=path;
            if(Files.exists(path)) {
                Files.write(path, list, StandardOpenOption.APPEND);
            }else {
                Files.write(path,list,StandardOpenOption.CREATE);
            }
        }catch (Exception e){
            System.err.print(e.toString());
        }
        System.out.print("Run reader? Y/N");
        if (in.next().trim().equalsIgnoreCase("Y")){
            Reader read = new Reader();
            if (gPath!=null)
            read.run(gPath);
        }
    }
}
