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
System.out.println(t5);                 //  ispisuje simbol
System.out.println(t5.ordinal());       //  ispisuje redni broj simbola u listi enumeracija, brojanje počinje od 0
System.out.println(t5.val2());          //  poziva metodu koja kvadrira eksplicitno zadatu numeričku vrijednost simbola..
}
}
}

/*
 *  A
 *  0
 *  1
 *  B
 *  1
 *  4
 *  C
 *  2
 *  9
 *  D
 *  3
 *  16
 *  E
 *  4
 *  16
 */