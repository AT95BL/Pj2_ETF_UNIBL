public class T6 {
public static void main(String[] args) {
int c1 = 0, c2 = 0;
switch (c1) {
case 0:
System.out.println("c1 is 0");
switch (c2) {
case 0:
System.out.println("c2 is 0");
break;
case 1:
System.out.println("c2 is 1");
break;
}
case 1:
System.out.println("c1 is 1");
break;
default:
System.out.println("c1 is unknown");
break;
}
}
}