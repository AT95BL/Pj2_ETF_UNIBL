
// E1.java
public class E1 extends Thread{
public static void main(String x[]) throws InterruptedException {
System.out.println("one");
E2 niz[] = {new E3("A") , new E3("B"), new E2(), new E3("D"), new E3("E")};
System.out.println("two");
for (E2 e : niz) {
System.out.println(e.id);
if (e instanceof E3){
new Thread(e).start();
} else{
e.start();
e.join();
}
}
System.out.println("three");
}
}
class E2 extends Thread {
String id;
public E2() { this("C"); }
E2(String id) {
System.out.println("E2(): " + id);
this.id = id;
if(id.equals("E")) {
new E3("F").start();
}
}
public void run() {
for (int i = 1; i < 6; i++) {
try {
sleep(1);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(id + ": " + i);
}
new Thread(new Runnable() {
public void run() {
for(int i=0; i<10; i++){
System.out.println(id + "1: " + i);
}
}
}).start();
new Thread(){
public void run(){
System.out.println(id + ": Thread start...");
synchronized (this) {
try {
super.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
for (int i = 0; i < 10; i++){
System.out.println(id + "2: " + i);
}
}
}
}.start();
}
}
class E3 extends E2 implements Runnable {
E3(String id) {
super(id);
System.out.println("E3()");
}
}