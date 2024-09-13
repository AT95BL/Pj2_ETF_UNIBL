
import java.io.*;


// F1.java
public class F1 {
public static void main(String[] args) throws Exception {
F5 f5 = new F5();
F4 f4 = new F4();
ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("F.out"));
o.writeObject(f5);
o.writeObject(f4);
o.close();
ObjectInputStream in = new ObjectInputStream(new FileInputStream("F.out"));
F5 f55 = (F5) in.readObject();
System.out.println(f55.a);
System.out.println(f55.b);
System.out.println(f55.f32.x);
System.out.println(f55.f32.y);
F4 f44 = (F4) in.readObject();
System.out.println(f44.a);
System.out.println(f44.b);
System.out.println(f44.f31.x);
System.out.println(f44.f31.y);
in.close();
}
}
class F2 {
transient int a = 1;
transient int b = 2;
public F2() {
System.out.println("F2 Constructor");
}
}
class F31 implements Serializable {
transient String x = "abc";
String y = null;
public F31() {
System.out.println("F31 Constructor");
y = "def";
}
}
class F32 implements Serializable {
String x = "ghi";
transient String y = null;
private void writeObject(ObjectOutputStream out) throws IOException {
System.out.println("F32.writeObject");
y = "jkl";
out.defaultWriteObject();
}
public F32() {
System.out.println("F32 Constructor");
}
}
class F4 implements Externalizable {
int a = 1;
transient int b = 2;
transient F31 f31 = new F31();
public F4() {
System.out.println("F4 Constructor");
}
public void writeExternal(ObjectOutput out) throws IOException {
out.writeInt(a);
out.writeInt(b);
out.writeObject(f31);
System.out.println("F4.writeExternal");
}
public void readExternal(ObjectInput in) throws IOException,
ClassNotFoundException {
System.out.println("F4.readExternal");
}
}
class F5 extends F2 implements Serializable {
transient long a = 32767;
transient int b = 1;
transient F32 f32 = new F32();
public F5() {
System.out.println("F5 Constructor");
}
private void writeObject(ObjectOutputStream out) throws IOException {
System.out.println("F5.writeObject");
out.writeLong(a);
out.writeInt(b);
out.writeObject(f32);
}
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
System.out.println("F5.readObject");
b = in.readInt();
a = in.readLong();
f32 = (F32) in.readObject();
}
}