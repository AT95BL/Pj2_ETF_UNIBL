
import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

/*
 *  Bounded Generics
 */
public class Example4{
    
    public static <T extends Number> List<T> arrayToList(T[] a){
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static void main(String[] args){
        
        Integer[] array = {1,2,3,4,5};
        Arrays.stream(array).forEach(System.out::println);

        List<Integer> list = arrayToList(array);
        list.stream().forEach(System.out::println);
    }
}
