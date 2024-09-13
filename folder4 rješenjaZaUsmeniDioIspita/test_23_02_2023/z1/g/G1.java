
public class G1 {
public static void main(String[] args) {
G3 g3 = new G3();
GT1<G3, G2> gt1 = new GT1<G3, G2>();
GTI<Long> gt2 = new GT1<Integer, Long>();
G2 g2 = new G2("g2");
GTI<Integer> gt3 = new GT1<>();
gt3.method(2);
g3.method(2f);
gt3.method();
g3.add(gt3.method());
g3.method2(3);
gt1.method(g2);
System.out.println(gt1.t.method());
gt1.t.method("gt1");
System.out.println(gt1.t.method());
g2.method("g22");
System.out.println(g3.method());
System.out.println(gt1.t.method());
System.out.println(gt2.method());
System.out.println(gt3.method());
}
}
class GT1<T, T3> implements GTI<T3> {
T3 t;
public void method(T3 t) {
this.t = t;
}
public T3 method() {
System.out.println("Class: " + t.getClass());
return null;
}
}
class G2 extends Exception {
String x = "G2";
G2(String x){
x = x;
}
void method(String a){
x = a;
}
String method(){
return x;
}
}
class G3 extends GT1<Integer, Float> implements GTI2<Integer>{
public void add(Integer i){
System.out.println("Class 2: " + t.getClass());
t += i;
}
public void method2(Integer t) {
this.t += t++;
}
}
interface GTI<T2> {
public void method(T2 t);
public T2 method();
}
interface GTI2<T1> {
public void method2(T1 t);
}