package sample;

import java.io.Serializable;

/**
 * Created by ivana on 3/12/2017.
 */
public class MyArrayList<T> implements Serializable{
    T[] list = (T[]) new Object[10];
    public T get(int index){
        if (index>=0&&index<list.length&&list[index]!=null){
            return list[index];
        }
        else return null;
    }
    public void add(T obj){
        boolean added=false;
        for (int i=0;i<list.length;i++){
            if (list[i]==null) {
                list[i]=obj;
                added=true;
                break;
            }
        }
        if (!added){
            T[] tmp =(T[]) new Object[list.length+10];
            for (int i=0;i<list.length;i++){
                tmp[i]=list[i];
            }
            list=tmp;
        }
    }
    public int size(){
        int size=0;
        for(T element: list){
            if(element==null) {
                continue;
            }
            size+=1;
        }
        return size;
    }
    @Override
    public String toString(){
        String string="";
        for(T el:list){
            if (el==null){
                continue;
            }
            string+=el+"\n";
        }
        return string;
    }
    public boolean isEmpty(){
        if (size()==0){
            return true;
        }else {
            return false;
        }
    }
    public void clear(){
        list= (T[]) new Object[10];;
    }



}
