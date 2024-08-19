
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Optional;

public class Main
{
	private static ArrayList<Oglas> generateOglasi()
	{
		ArrayList<Oglas> list=new ArrayList<>();
		list.addAll(generateOglasiByCategory(KategorijaPosla.IT));
		list.addAll(generateOglasiByCategory(KategorijaPosla.EKONOMIJA));
		list.addAll(generateOglasiByCategory(KategorijaPosla.MEDICINA));
		list.addAll(generateOglasiByCategory(KategorijaPosla.NOVINARSTVO));
		list.addAll(generateOglasiByCategory(KategorijaPosla.PRAVO));
		return list;
	}
	
	// Metoda koja za argument(KategorijaPosla kategorija) kreira 12_oglasa(ArrayList<Oglas>) .. 
	private static ArrayList<Oglas> generateOglasiByCategory(KategorijaPosla kategorija)
	{
		ArrayList<Oglas> list=new ArrayList<>();
		String[]gradovi=new String[]{"BanjaLuka","Prijedor","Bijeljina","Trebinje"};
		Random random=new Random();
		for(int i=1;i<=12;i++)
			list.add(new Oglas("Naziv"+i,
			"Opis"+i,
			new Date(2022,random.nextInt(13)+1,random.nextInt(31)+1),
			random.nextInt(15),
			random.nextInt(2500)+500,
			random.nextInt(10),
			gradovi[random.nextInt(gradovi.length)],
			kategorija));
		return list;
	}
	
	public static void main(String[]args)
	{
		var list=generateOglasi();

		//	 Ukupan broj objavljenih oglasa u jednom danu (za svaki datum pojedinačno)
			/*
		 	* 	 Znači, ideja je da se napravi map-stream(datum=key, brojObjavljenihOglasaZaTajDatum=value) tj. da 'datum mapira broj'
			* 	 zatim ide .entrySet() da pridobiješ sve ključeve iz mape,
				 zatim, od te dobijene kolekcije ključeva pravim stream tako da ide .stream()
		 	* 	 zatim .forEach( (s)-> {System.out.println(s.getKey() + "-" + s.getValue());});
		 	* 	 tj. (s)-> je naravno 'lambda' preko koje se poziva System.out.println(..) koji na početni ekran ispisuje
		 	* 	 "ključ" - "vrijednost"
		 	*/
		list.stream().collect(Collectors.groupingBy(Oglas::getDate,Collectors.counting()))
			.entrySet()
			.stream()
			.forEach((s)->{System.out.println(s.getKey()+"-"+s.getValue());});
		
		//	Prosječnu ponuđenu platu u kategoriji IT
		System.out.println("Prosjecna plata u IT");
		var rez=list.stream()
					.filter((s)->s.kategorija==KategorijaPosla.IT)	//	moraš znati kada/zašto se poziva .filter(); !!
					.mapToDouble(Oglas::getPlata)
					.average();
		System.out.println(rez.getAsDouble());

		//	Najčešći grad u kom se nudi posao
			/*
			 * 	Ideja je da se napravi map-stream(grad=key, brojObjavljenihOglasaUtomGradu) tj. da 'grad mapira broj'
			 *  zatim ide .entrySet() da pridobiješ sve ključeve iz mape,
			 * 	zatim se od te prethodno-dobijene-kolekcije-ključeva pravi novi stream(ipak radimo sa stream-ovima..) pozivom .stream()..
			 *  Pazi sad, cilj metode jeste da jednu vrijednost izdvojimo i pohranimo u rez1 tako da sljedeći korak bi bio
			 * 		.max((a,b)->a.getValue().compareTo(b.getValue())); 
			 */
		System.out.println("Najcesci grad u kojem se nudi posao");
		var rez1=list.stream()
					 .collect(Collectors.groupingBy(Oglas::getGrad,Collectors.counting()))
					 .entrySet()
					 .stream()
					 .max((a,b)->a.getValue().compareTo(b.getValue()));
		System.out.println(rez1);
		
		//	Prikaz svih oglasa grupisanih po mjesecima (mjesec odrediti iz datuma)
		System.out.println("Oglasi u mjesecima:");
		list.stream().collect(Collectors.groupingBy(a->{return a.getDate().getMonth();}))
					 .entrySet()
					 .stream()
					 .forEach((s)->{
			System.out.println("Mjesec:"+(s.getKey()+1));	//	+1? Je li Jan 0./1. mjesec u godini!? :D
			s.getValue().forEach(System.out::println);
		});
		
		//	Prikaz svih oglasa sortiranih po vremenu trajanja u opadajućem redoslijedu
		System.out.println("Oglasi sortirani prema trajanju:");
		list.stream()
			.sorted((a,b)->b.vrijemeTrajanjaOglasa-a.vrijemeTrajanjaOglasa)
			.forEach(System.out::println);
		
		//	Prikaz najbolje plaćenog posla za svaku kategoriju
		System.out.println("Najbolje placen po kategoriji!!");
		list.stream().collect(Collectors.groupingBy(Oglas::getKategorija,Collectors.maxBy((a,b)->a.plata-b.plata)))
			.entrySet()
			.stream()
			.forEach((s)->{	System.out.println(s.getKey()+"-"+s.getValue().get());	
			 });
		
		//	Prosječan broj godina radnog iskustva ukupno i posebno za svaku kategoriju.
		System.out.println("Prosjecno radno iskustvo:");
		var rez12=list.stream().mapToInt(Oglas::getGodineIskustva).average();
		System.out.println(rez12.getAsDouble());
		
		System.out.println("Prosjecno iskustvo po kategorijama:");
		list.stream().collect(Collectors.groupingBy(Oglas::getKategorija,Collectors.averagingDouble(Oglas::getGodineIskustva)))
			.entrySet()
			.stream()
			.forEach((s)->{
				System.out.println(s.getKey()+"-"+s.getValue());
			});				
	}
}

/*

	Collectors.counting() ?

 * Naravno, objasniću svaki deo koda koji koristi Java Stream API u `main` metodi:

### 1. Brojanje oglasa po datumima
```java
list.stream()
    .collect(Collectors.groupingBy(Oglas::getDate, Collectors.counting()))
    .entrySet()
    .stream()
    .forEach((s) -> { System.out.println(s.getKey() + "-" + s.getValue()); });
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `collect(Collectors.groupingBy(Oglas::getDate, Collectors.counting()))`: Grupira oglase po datumu (`Oglas::getDate`) i broji koliko oglasa ima za svaki datum (`Collectors.counting()`).
- `entrySet().stream()`: Kreira stream iz skupa unosa (`Map.Entry`) rezultujuće mape.
- `forEach((s) -> { System.out.println(s.getKey() + "-" + s.getValue()); })`: Za svaki unos, ispisuje datum (`s.getKey()`) i broj oglasa za taj datum (`s.getValue()`).

### 2. Prosječna plata u IT kategoriji
```java
var rez = list.stream()
              .filter((s) -> s.kategorija == KategorijaPosla.IT)
              .mapToDouble(Oglas::getPlata)
              .average();
System.out.println(rez.getAsDouble());
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `filter((s) -> s.kategorija == KategorijaPosla.IT)`: Filtrira oglase koji pripadaju kategoriji `IT`.
- `mapToDouble(Oglas::getPlata)`: Mapira preostale oglase na njihove plate.
- `average()`: Izračunava prosječnu platu.
- `rez.getAsDouble()`: Ispisuje prosječnu platu.

### 3. Najčešći grad u kojem se nudi posao
```java
var rez1 = list.stream()
               .collect(Collectors.groupingBy(Oglas::getGrad, Collectors.counting()))
               .entrySet()
               .stream()
               .max((a, b) -> a.getValue().compareTo(b.getValue()));
System.out.println(rez1);
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `collect(Collectors.groupingBy(Oglas::getGrad, Collectors.counting()))`: Grupira oglase po gradu (`Oglas::getGrad`) i broji koliko oglasa ima za svaki grad (`Collectors.counting()`).
- `entrySet().stream()`: Kreira stream iz skupa unosa rezultujuće mape.
- `max((a, b) -> a.getValue().compareTo(b.getValue()))`: Pronalazi unos sa najvećim brojem oglasa (najčešći grad).
- `System.out.println(rez1)`: Ispisuje najčešći grad.

### 4. Grupisanje oglasa po mesecima
```java
list.stream()
    .collect(Collectors.groupingBy(a -> { return a.getDate().getMonth(); }))
    .entrySet()
    .stream()
    .forEach((s) -> {
        System.out.println("Mjesec:" + (s.getKey() + 1));
        s.getValue().forEach(System.out::println);
    });
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `collect(Collectors.groupingBy(a -> { return a.getDate().getMonth(); }))`: Grupira oglase po mesecu (`a.getDate().getMonth()`).
- `entrySet().stream()`: Kreira stream iz skupa unosa rezultujuće mape.
- `forEach((s) -> { ... })`: Za svaki unos (mesec), ispisuje broj meseca (`s.getKey() + 1`) i sve oglase za taj mesec (`s.getValue().forEach(System.out::println)`).

### 5. Sortiranje oglasa prema trajanju
```java
list.stream()
    .sorted((a, b) -> b.vrijemeTrajanjaOglasa - a.vrijemeTrajanjaOglasa)
    .forEach(System.out::println);
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `sorted((a, b) -> b.vrijemeTrajanjaOglasa - a.vrijemeTrajanjaOglasa)`: Sortira oglase prema trajanju oglasa u opadajućem redosledu (`b.vrijemeTrajanjaOglasa - a.vrijemeTrajanjaOglasa`).
- `forEach(System.out::println)`: Ispisuje svaki oglas.

### 6. Najbolje plaćen oglas po kategoriji
```java
list.stream()
    .collect(Collectors.groupingBy(Oglas::getKategorija, Collectors.maxBy((a, b) -> a.plata - b.plata)))
    .entrySet()
    .stream()
    .forEach((s) -> {
        System.out.println(s.getKey() + "-" + s.getValue().get());
    });
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `collect(Collectors.groupingBy(Oglas::getKategorija, Collectors.maxBy((a, b) -> a.plata - b.plata)))`: Grupira oglase po kategoriji (`Oglas::getKategorija`) i pronalazi oglas sa najvećom platom u svakoj kategoriji (`Collectors.maxBy((a, b) -> a.plata - b.plata)`).
- `entrySet().stream()`: Kreira stream iz skupa unosa rezultujuće mape.
- `forEach((s) -> { ... })`: Za svaki unos (kategorija), ispisuje kategoriju (`s.getKey()`) i najbolje plaćen oglas u toj kategoriji (`s.getValue().get()`).

### 7. Prosječno radno iskustvo
```java
var rez12 = list.stream()
                .mapToInt(Oglas::getGodineIskustva)
                .average();
System.out.println(rez12.getAsDouble());
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `mapToInt(Oglas::getGodineIskustva)`: Mapira preostale oglase na njihove godine iskustva.
- `average()`: Izračunava prosječno radno iskustvo.
- `rez12.getAsDouble()`: Ispisuje prosječno radno iskustvo.

### 8. Prosječno iskustvo po kategorijama
```java
list.stream()
    .collect(Collectors.groupingBy(Oglas::getKategorija, Collectors.averagingDouble(Oglas::getGodineIskustva)))
    .entrySet()
    .stream()
    .forEach((s) -> {
        System.out.println(s.getKey() + "-" + s.getValue());
    });
```

**Objašnjenje:**
- `list.stream()`: Kreira stream iz liste `list`.
- `collect(Collectors.groupingBy(Oglas::getKategorija, Collectors.averagingDouble(Oglas::getGodineIskustva)))`: Grupira oglase po kategoriji (`Oglas::getKategorija`) i izračunava prosečne godine iskustva za svaku kategoriju (`Collectors.averagingDouble(Oglas::getGodineIskustva)`).
- `entrySet().stream()`: Kreira stream iz skupa unosa rezultujuće mape.
- `forEach((s) -> { ... })`: Za svaki unos (kategorija), ispisuje kategoriju (`s.getKey()`) i prosečne godine iskustva (`s.getValue()`).
 */