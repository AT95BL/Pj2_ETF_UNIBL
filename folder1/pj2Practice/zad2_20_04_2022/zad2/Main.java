
import java.util.*;

public class Main{
	
	public static void main(String[] args){
		
		A[] a = new A[10];
		B[] b = new B[10];
		C[] c = new C[10];
		
		for(int i=0; i < 10; i++){
			a[i] = new A((double)(100+i), "nameA"+i, Status.values()[i%3]);
			b[i] = new B((double)(100+i), "nameB"+i, Status.values()[i%3]);
			c[i] = new C((double)(100+i), "nameC"+i, Status.values()[i%3]);
		}
		
		Random random = new Random();
		List<MyInterface> result = groupAndSumByName(Status.values()[random.nextInt() % 3], a, b, c);
        
        // Print the result
        for (MyInterface item : result) {
            System.out.println("Name: " + item.getName() + ", Value: " + item.getValue());
        }
	}
	
	//	https://www.baeldung.com/java-generics
	/*
		<T extends MyInterface> -naglašavamo to da će metoda imati posla sa klasama nasljednicama interface-a imena MyInterface..
		
		Argumenti funkcije jesu 'Status filterStatus' pri čemu je Status enumeracija, a T[]... arrays proizvoljan broj nizova!
		Pri pozivu funkcije obavezno primjetiti 'a, b, c'!!
	*/
	@SafeVarargs
    public static <T extends MyInterface> List<MyInterface> groupAndSumByName(Status filterStatus, T[]... arrays) {
        Map<String, Double> groupedMap = new HashMap<>();
        
        for (T[] array : arrays) {
            for (T item : array) {
                if (item.getStatus() == filterStatus) {
                    groupedMap.put(item.getName(),
                            groupedMap.getOrDefault(item.getName(), 0.0) + item.getValue());
                }
            }
        }
        
        // Convert the map back to a list of MyInterface objects
        List<MyInterface> resultList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : groupedMap.entrySet()) {
            resultList.add(new A(entry.getValue(), entry.getKey(), filterStatus));
        }
        
        return resultList;
    }
	
	/*
		@SafeVarargs
		public static <T extends MyInterface> List<MyInterface> groupAndSumByName(Status filterStatus, T[]... arrays){
			Map<String, Double> groupedMap = new HashMap<>();
			
			for(var array : arrays){
				for(var item:array){
					if(item.getStatus() == filterStatus){
						groupedMap.put(item.getName(),
								groupedMap.getOrDefault(groupedMap.getValue, 0.0) + item.getValue());
					}
				}
			}
			
			List<MyInterface> resultList = new ArrayList<>(); 
			for(Map.Entry<String, Double> entry : groupedMap.entrySet()){
				resultList.add(new A(entry.getValue(), entry.getKey(), filterStatus));
			}
			
			return resultList;
		}
	*/
}

/*
	Ovaj Java kod pretvara `Map<String, Double>` nazad u listu objekata koji implementiraju `MyInterface`. Evo detaljnog objašnjenja:

	### 1. **`List<MyInterface> resultList = new ArrayList<>();`**:
		- **Značenje:** Kreira novu praznu listu tipa `MyInterface`. 
		Ova lista će na kraju sadržati objekte koji implementiraju ovaj interfejs (u ovom slučaju, biće to objekti klase `A`).

	### 2. **`for (Map.Entry<String, Double> entry : groupedMap.entrySet())`**:
    - **Značenje:** Ovo je "for-each" petlja koja iterira kroz svaki unos (`entry`) u skupu unosa (`entrySet`) mape `groupedMap`.

	#### **Pojasnjenje `Map.Entry<String, Double> entry`**:
	- **`Map.Entry<String, Double>`:** `Map.Entry` je ugnježdeni interfejs u okviru interfejsa `Map` i predstavlja jedan unos (par ključ-vrednost) u mapi.
	- **`String`:** Tip ključa u mapi `groupedMap`. U ovom slučaju, ključ je `String`, što bi trebalo da predstavlja ime (name).
	- **`Double`:** Tip vrednosti u mapi `groupedMap`. U ovom slučaju, vrednost je `Double`, što bi trebalo da predstavlja sumu `value` vrednosti svih objekata sa istim imenom.
	- **`entry`:** Promenljiva koja predstavlja trenutni unos (par ključ-vrednost) u petlji.

	#### **Pojasnjenje `groupedMap.entrySet()`**:
	- **`groupedMap`:** Ovo je mapa (`Map<String, Double>`) koja je ranije popunjena tokom grupisanja i sabiranja vrednosti u prethodnom kodu.
	- **`entrySet()`:** Metoda `entrySet()` vraća skup svih unosa (parova ključ-vrednost) u mapi. Svaki unos je instanca `Map.Entry`.
	- **`entrySet()` kao kolekcija:** `entrySet()` se može posmatrati kao kolekcija svih parova (klasifikovanih kao `Map.Entry`), 
		 gde svaki par sadrži ključ i odgovarajuću vrednost iz mape.

	### 3. **`resultList.add(new A(entry.getValue(), entry.getKey(), filterStatus));`**:
	- **Značenje:** Kreira novi objekat klase `A` za svaki unos (`entry`) u mapi `groupedMap` i dodaje taj objekat u listu `resultList`.
	- **`new A(entry.getValue(), entry.getKey(), filterStatus)`:** 
     - **`entry.getValue()`**: Vraća vrednost (tipa `Double`) iz trenutnog unosa u mapi. Ovo će postati `value` polje za novi objekat `A`.
     - **`entry.getKey()`**: Vraća ključ (tipa `String`) iz trenutnog unosa u mapi. Ovo će postati `name` polje za novi objekat `A`.
     - **`filterStatus`:** Prolazi status koji je korišćen za filtriranje ranije, pa svi novi objekti `A` koje kreirate imaju isti `Status`.

	### **Šta ovaj kod radi?**
	- Kod prolazi kroz sve unose u `groupedMap`.
	- Za svaki unos (ključ-vrednost par), kreira novi objekat klase `A` koristeći vrednost kao `value`, ključ kao `name`, i prethodno korišćeni `filterStatus` kao `status`.
	- Te nove objekte `A` dodaje u listu `resultList`.

	### **Primena u kontekstu zadatka**:
	- Nakon što su vrednosti iz nizova grupisane i sabrane u `groupedMap`, 
	ovaj deo koda konvertuje te podatke nazad u listu objekata `MyInterface` (klasa `A`), 
	koji imaju sumirane vrednosti i pripadajući status. 
	Na kraju, dobijate listu `resultList`, koja sadrži sve jedinstvene objekte sa njihovim agregiranim vrednostima i uniformnim statusom.
*/