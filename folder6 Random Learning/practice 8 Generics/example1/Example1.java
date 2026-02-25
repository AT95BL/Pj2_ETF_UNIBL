import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Example1{
    
    public static void main(String[] args){
        List list = new LinkedList<>();         //  <=> List<Object> list = new LinkedList<>(); praviš listu Kolumbo..
        list.add(new Integer(1));         //  <=> Object obj = new Integer(1);
        Integer i = list.iterator().next();     //  <=> Integer i = koZnaŠtaaa te se zbog toga žali i naš kompajler!!
        
        System.out.println(i);
    }
}