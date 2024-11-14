
import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

public class Example3 {
    
    /*
     *  The <T> in the method signature implies that the method will be dealing with generic type T. 
     *  This is needed even if the method is returning void.
     */
    public static <T> List<T> fromArrayToList(T[] a){
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static void main(String[] args){
        
        Integer[] array = {1,2,3,4,5};       //  'int umjesto Integer' i eto greške na list-inicijalizator-liniji .. 
        Arrays.stream(array).forEach(System.out::println);

        List<Integer> list;
        list = Example3.fromArrayToList(array);
        list.stream().forEach(System.out::println);
    }
}
