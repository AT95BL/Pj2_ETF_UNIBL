
public class T1 {
public static void main(String[] args) {
T11 cube = method(() -> new T11());
System.out.println(cube.toString());
}
public static T11 method(IF<T11> i) {
return i.get();
}
}
class T11 {
public T11() {
System.out.println("T11 constructor...");
}
}
interface IF<T> {
T get();
}