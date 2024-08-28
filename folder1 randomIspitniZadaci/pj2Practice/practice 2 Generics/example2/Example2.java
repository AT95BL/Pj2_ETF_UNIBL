
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Example2{
    
    public static void main(String[] args){
        List list = new LinkedList<>();         //  <=> List<Object> list = new LinkedList<>(); praviš listu Kolumbo..
        list.add(new Integer(1));         //  <=> Object obj = new Integer(1);
        Integer i = (Integer)list.iterator().next();     // Eksplicitni kastovanje je rješilo kompajlersku nedoumicu..  
        // Da bi se izbjegle ovakve pojave, uveden je 'dijamant <>' Operator, tj. List<Integer> list = new LinkedList<>();
        System.out.println(i);
    }
}