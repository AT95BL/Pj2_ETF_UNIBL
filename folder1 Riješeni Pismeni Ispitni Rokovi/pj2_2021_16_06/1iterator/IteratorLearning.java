import java.util.Iterator;
import java.util.ArrayList;

public class IteratorLearning{
	
	private ArrayList<String> names = new ArrayList<>();
	private static final Object lock = new Object();
	
    // Constructor
	public IteratorLearning(){
		initializeNames();
	}
	
	public void initializeNames(){
		for(int i =0; i < 100; i++){
			this.names.add("name" + i);
		}
	}
	
	public void removeElements(String name) {
        synchronized (lock) { // Koristi lock za thread-safe pristup listi
            Iterator<String> iterator = this.names.iterator();

            while (iterator.hasNext()) {
                String catcher = iterator.next();
                if (catcher.equals(name)) {
                    iterator.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        synchronized (lock) { // Koristi lock za thread-safe pristup listi
            Iterator<String> iterator = this.names.iterator();
            StringBuilder res = new StringBuilder();

            while (iterator.hasNext()) {
                String name = iterator.next();
                res.append(name).append("\n");
            }

            return res.toString();
        }
    }
	
	public static void main(String[] args){
		
		IteratorLearning il = new IteratorLearning();
		il.removeElements("name92");
		System.out.println(il);
	}
}

