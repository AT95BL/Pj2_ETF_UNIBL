
public class C1 {
C2 c2 = new C2();
C1() {
System.out.println("C1");
}
public static void main(String[] args) {
C1 c1 = new C1();
try {
c1.metoda();
System.out.println("main 1");
} catch (CE2 e) {
System.out.println("main 2: " + e);
} catch (CE1 e) {
System.out.println("main 3: " + e);
} catch (Error e) {
System.out.println("main 4: " + e);
} catch (Throwable e) {
System.out.println("main 5: " + e);
} finally {
System.out.println("finally 1");
}
C3 c3 = new C3();
c3.metoda();
}
void metoda() throws Throwable {
try {
c2.metoda();
System.out.println("C1: metoda()");
} finally {
System.out.println("finally 2");
}
}
}
class C2 {
C3 c3;
C2() {
System.out.println("C2");
}
void metoda() throws CE1 {
System.out.println("C2: metoda()");
c3.metoda();
}
}
class C3 {
C3() {
System.out.println("C3");
}
C3(String s) {
this();
System.out.println("C3 " + s);
}
protected void metoda() {
try{
System.out.println("C3: metoda()");
throw new CE2("CE2");
} catch (CE2 e) {
System.out.println("C3: catch");
} finally{
System.out.println("finally 3");
}
}
}
class CE1 extends Exception {
CE1(String s) {
super(s);
System.out.println("CE1: " + s);
}
}
class CE2 extends CE1 {
CE2(String s) throws CE1 {
super(s);
System.out.println("CE2: " + s);
throw new CE1(s);
}
}