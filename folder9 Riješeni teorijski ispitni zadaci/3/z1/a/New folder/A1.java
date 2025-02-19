
import java.io.Serializable;

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