package sample;

/**
 * Created by Mazas on 3/22/2017.
 */
public class Generic<T,N> {
    private T obj1;
    private T obj2;

    public Generic(){}
    public Generic(T obj1){this.obj1=obj1;}
    public Generic(T obj1, T obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public T getObj2() {
        return obj2;
    }

    public void setObj2(T obj2) {
        this.obj2 = obj2;
    }
}
