
import java.util.Arrays;

public class T7 {
private String str;
public T7(String str) {
this.str = str;
}
public String toString() {
return this.str;
}
public static void main(String args[]) {
T7 h1 = new T7("2");
String s1 = new String("1");
Object arr[] = new Object[2];
arr[0] = h1;
arr[1] = s1;
Arrays.sort(arr);
for (Object o : arr) {
System.out.print(o + " ");
}
}
}