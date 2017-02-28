package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by ivana on 2/23/2017.
 */
public class Reader {
    public void run(Path path){
        try {
                List<String> list = Files.readAllLines(path);
                double a, b;
                a=Double.parseDouble(list.get(0));
                b=Double.parseDouble(list.get(1));
            System.out.printf("%.2f,*%.2f=%.2f%n",a,b,a*b);
            list.clear();
            list.add(String.valueOf(a*b));
            Files.write(path,list, StandardOpenOption.APPEND);
        }catch (Exception e){
            System.err.print(e.toString());
        }
    }
}
