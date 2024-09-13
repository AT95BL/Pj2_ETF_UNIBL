
// A1.java
public class A1 {
private A1 a1;
static{
System.out.println("A1-S");
}
{
System.out.println("A1-N");
}
public A1() {
System.out.println("A1");
}
public A1(A1 a1){
System.out.println("A1(A1)");
this.a1 = a1;
System.out.println("---");
new A2(a1);
}
void metoda(){
System.out.println("metoda A1");
}
public static void main(String[] args) {
A1 a1 = new A1();
a1.metoda();
A4 a4 = new A4();
a4.metoda();
a4.metoda2();
A3 a3 = new A3();
A2 a2 = new A2(a1);
a3.metoda();
a2.metoda();
}
}

