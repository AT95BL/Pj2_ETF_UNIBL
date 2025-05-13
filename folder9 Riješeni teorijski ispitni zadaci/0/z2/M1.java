
public class M1 extends M2 {
static int MEM = 0;
static int counter = 0;
int id;
M1 m;
double dm[] = new double[2_500_000]; // 40 MB
long lm[] = new long[1_250_000]; // 5 MB
int im[] = new int[5_000_000]; // 10 MB
public M1(M1 m, int id){
counter = id+1;
System.out.print("M1 " + id);
if(m!=null)
System.out.println(" - m -> " + m.id);
else
System.out.println(" - m -> null");
this.m = m;
this.id = id;
}
protected void finalize(){
System.out.println(this.getClass().getName() + " finalize");
}
public static void main(String args[]){
M1 m0 = null;
M1 m1 = new M1(m0, 1);
M1 m2 = new M1(m1, 2);
M1 m3 = new M1(m2, 3);
M1 array[][][] = new M1[2][3][2];
for (int i = 0; i < array.length; i++)
for (int j = 0; j < array[i].length; j++)
for(int k=0; k < array[i][j].length; k++){
array[i][j][k]=(i+j+k)%2==0?new M1(test()==1?m2:m3,counter):null;
System.out.println("array["+ i +"]"+"["+ j +"]"+"["+ k +"]" + test());
}
System.gc(); // 1
for (int i = 0; i < array.length; i++)
for (int j = 0; j < array[i].length; j++){
System.out.println("array["+ i +"]"+"["+ j +"]");
array[i][j][0] = null;
}
array[0][1][1].m = null;
array[1][1][0].m = null;
array[1][0][1].m = null;
System.gc(); // 2
array[0][1] = null;
array[1][0] = null;
System.gc(); // 3
}
private static int test() {
return counter%2==0?0:1;
}
}
class M2{
float fm[] = new float[12_500_000]; // 100 MB
public M2() {
System.out.println("M2");
}
protected void finalize(){
System.out.println(this.getClass().getName() + " finalize");
}
}