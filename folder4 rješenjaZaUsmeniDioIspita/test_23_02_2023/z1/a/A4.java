
import java.io.Serializable;

class A4 extends A3 {
private A1 a = new A1();
private A2 a2 = new A2(new A1(new A1(new A1(new A2()))));
Serializable a3 = new A3(a2, a1);
static{
System.out.println("A4-S");
}
{
System.out.println("A4-N");
}
public A4() {
a2.metoda();
System.out.println("A4");
a.metoda();
((A1) a3).metoda();
}
protected void metoda(){
System.out.println("metoda A4");
}
}