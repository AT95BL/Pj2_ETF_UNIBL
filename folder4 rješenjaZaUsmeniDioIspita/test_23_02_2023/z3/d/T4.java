
public class T4 {
public static void main(String[] args) {
label:
for (int i = 0; i < 2; i++) {
for (int j = 0; j < 12; j++) {
if (j == 4)
continue;
if (j == 7)
continue label;
System.out.println(i + ", " + j);
}
}
}
}

/*
	0, 0
	0, 1
	0, 2
	0, 3
	0, 5
	0, 6
	1, 0
	1, 1
	1, 2
	1, 3
	1, 5
	1, 6
	
*/