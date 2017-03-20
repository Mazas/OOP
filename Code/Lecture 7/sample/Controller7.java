package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * Created by ivana on 3/20/2017.
 */
public class Controller7 extends Controller{
    @FXML private TextField text;
    public void doIt(){
        int[] arr1 = new int[3];
        int[] arr2 = {1,2,3,4};
        try{
            copy(arr1,arr2);
        }catch (IndexOutOfBoundsException e){
            showError(e,"Second array to small");
        }catch (Exception e){
            showError(e);
        }
    }
    private void copy(int[] a, int[] b){
        for (int i = 0;i<b.length;i++){
            a[i]=b[i];
        }
    }

}
