
import java.io.Serializable;

class A3 extends A2 implements Serializable {
static{
System.out.println("A3-S");
}
{
System.out.println("A3-N");
}
public A3() {
System.out.println("A3");
}
public A3(A2 a2) {
this();
System.out.println("A3(A2)");
}
public A3(A2 a2, A1 a1) {
this(a2);
System.out.println("A3(A2, A1)");
}
void metoda(){
System.out.println("metoda A3");
}
void metoda2(){
System.out.println("metoda2 A3");
}
}