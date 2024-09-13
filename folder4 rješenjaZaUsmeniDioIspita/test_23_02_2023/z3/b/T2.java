
public class T2 {
public static void main(String arg[]) {
int i = 4;
for (; i <= 12; i+=2) {
i += i++;
i -= 1;
i++;
i += 1;
i = i++;
}
System.out.println(--i);
}
}

// 24