public class T8 {
public static void main(String[] args) {
String array[] = { "a", "qwerty", "abc", "def", "test" };
Arrays.sort(array, new MyComparator());
for (String e : array) {
System.out.print(e);
}
}
}
class MyComparator implements Comparator<String> {
@Override
public int compare(String s1, String s2) {
return s2.compareTo(s1);
}
}