package sample;


/**
 * Created by Mazas on 3/22/2017.
 */
public class MyGeneralObject<T extends Comparable<T>>{
    public T smallest(T o){
        if(o.compareTo(object)>0){
            return object;
        }else return o;
    }
    private T object;

    public T getObject() {
        return object;
    }
    public MyGeneralObject(T o){this.object=o;}
    public MyGeneralObject(){}

    public void setObject(T object) {
        this.object = object;
    }
    public boolean isEqual(T obj){
        return obj.equals(object);
    }
    public boolean isInteger(){
        return object instanceof Integer;
    }
}
