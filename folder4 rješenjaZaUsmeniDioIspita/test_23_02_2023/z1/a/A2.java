
import java.io.Serializable;

class A2 extends A1 {
A1 a1 = new A4();
static{
System.out.println("A2-S");
}
{
System.out.println("A2-N");
}
public A2() {
this(new A1());
System.out.println("A2");
}
public A2(A1 a1){
this.a1 = a1;
System.out.println("A2(A1)");
}
private void metoda2(){
System.out.println("metoda2 A2");
}
}