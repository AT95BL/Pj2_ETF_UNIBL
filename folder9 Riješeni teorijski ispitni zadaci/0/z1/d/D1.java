
public class D1 {
public static void main(String[] args) {
String test = "Faculty of Electrical Engineering!";
String res = exec(t -> {
String result = "";
for (int i = t.length() - 1; i >= 0; i--) {
result += t.charAt(--i);
}
return result;
}, test);
System.out.println(res);
res = exec(new D2()::exec, test);
System.out.println(res);
res = new DI() {
public String exec(String s) {
return s.toLowerCase();
}
}.exec(test, 3);
System.out.println(res);
}
static String exec(DI sf, String s) {
return sf.exec(s);
}
}
class D2 {
public String exec(String s) {
String result = "";
for (int i = s.length() - 1; i >= 0; i--) {
result += s.charAt(i);
}
return result;
}
}
interface DI {
public String exec(String s);
default String exec(String s, int i) {
return s.substring(i);
}
}