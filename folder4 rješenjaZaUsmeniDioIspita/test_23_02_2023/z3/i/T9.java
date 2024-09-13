public enum T9 {
A (1), B (2), C (3), D (4), E (4);
int val;
T9(int a){
val = a;
}
int val2(){
return val*val;
}
public static void main(String[] args) {
for(T9 t5: T9.values()){
System.out.println(t5);
System.out.println(t5.ordinal());
System.out.println(t5.val2());
}
}
}