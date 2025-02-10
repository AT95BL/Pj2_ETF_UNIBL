
public class B1 {
protected B1(){ System.out.println("B1"); }
double x = 0;
public static void main(String[] args) throws Exception {
new B1().metoda();
B2 b2 = new B2(3.5);
B3 b3 = new B3(b2);
if(b2.equals(b3)){
B1 b[][] = {{b2, b3}, {b2}};
for (B1[] tmp : b) {
for(B1 b1: tmp) {
System.out.println(b1.metoda());
}
}
}else
new B3(b2).metoda();
B1 b1 = (B1) new B1().clone();
System.out.println(b1.metoda().metoda());
}
public B2 metoda(){
return new B2();
}
@Override
public int hashCode() {
return (int) x;
}
@Override
public boolean equals(Object obj) {
B1 tmp = (B1) obj;
if(tmp.hashCode()==this.hashCode())
return true;
return false;
}
}
class B2 extends B1 {
int x = 1;
public B2(){
System.out.println("B2");
}
B2(B2 b2){
System.out.println("B2 - 1");
}
B2(double x){
x = x;
System.out.println("B2 - 2");
}
public B3 metoda(){
return new B3(this);
}
void setX(int x){
x = x;
}
@Override
public String toString() {
return super.toString() + " : " + x;
}
}
class B3 extends B2 implements BI {
int x = 0;
B3(B2 b2){
System.out.println("B3");
x = b2.x;
b2.setX(x);
}
public B3 metoda(){
return new B3(new B2());
}
}
interface BI {
B2 metoda();
Object clone() throws CloneNotSupportedException;
int hashCode();
}