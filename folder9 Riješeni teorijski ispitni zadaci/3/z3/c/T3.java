
public class T3 {
public static void main(String[] args) throws InterruptedException {
Runnable r = () -> {
Thread.sleep(1);            //  Tu program puca! Razlog jeste nedostatak Try-Catch bloka!!
int sum = 0;
for (int i = 0; i < 5; i++) {
sum += i;
}
System.out.println(sum);
};
new Thread(r).start();
}
}