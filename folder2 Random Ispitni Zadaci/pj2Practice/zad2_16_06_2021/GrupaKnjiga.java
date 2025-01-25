
import java.util.*;
import java.util.stream.*;

public class GrupaKnjiga{
	
	Set<Knjiga> knjige = new HashSet<>();
	
	// Constructor
	public GrupaKnjiga(){
		this.knjige = new HashSet<>();
	}
	
	// Constructor
	public GrupaKnjiga(Set<Knjiga> knjige){
		this.knjige = knjige;
	}
	
	// dodaj samo jednu knjigu ..
	public void dodajKnjigu(Knjiga knjiga){
		this.knjige.add(knjiga);
	}
	
	// dodaj knjige iz neke druge kolekcije..
	public void dodajKnjige(Set<Knjiga> knjige){
		this.knjige.addAll(knjige);
	}
	
	// ako ti mozda zatrebaju sve te knjige ..
	public Set<Knjiga> getKnjige(){
		return this.knjige;
	}
		
	public static void main(String[] args){
		
		GrupaKnjiga prvaGrupa = new GrupaKnjiga();
		GrupaKnjiga drugaGrupa = new GrupaKnjiga();
		
		// brzine radi, sve jednom for petljom ..
		for(int i=0; i < 20; i++){
			prvaGrupa.dodajKnjigu( new Knjiga("Naslov"+i, "Pisac"+i, 2000+i, Zanr.values()[i%4]) );
			drugaGrupa.dodajKnjigu( new Knjiga("Naslov"+i+20, "Pisac"+i+20, 2000+i, Zanr.values()[i%4]) );
		}
		
		//	U Java programskom jeziku, kroz kolekciju, UVIJEK PROLAZI(MA BILO KAKVA OBRADA) KORISTEĆI JAVA STREAM-API
		System.out.println("Sve knjige:");
		prvaGrupa.getKnjige().stream().forEach(System.out::println);
		drugaGrupa.getKnjige().stream().forEach(System.out::println);
		
		System.out.println("Spajanje grupe knjiga: ");
		prvaGrupa.dodajKnjige(drugaGrupa.getKnjige());
		prvaGrupa.getKnjige().stream().forEach(System.out::println);
		// u Set<E> ima metode .clear() koju cu da iskoristim za ciscenje objekta referenciranog sa 'drugaGrupa' ..
		drugaGrupa.getKnjige().clear();
		
		System.out.println("Filtiranje SVIH knjiga po zanru!!");							// znaci da treba umapirati!! (Zanr)->(ListaKnjiga)
		prvaGrupa.getKnjige().stream()
							.collect(Collectors.groupingBy(Knjiga::getZanr))
							.forEach((zanr, knjige)->{
								System.out.println("\nZanr " + zanr);
								knjige.forEach(System.out::println);
							});
							
		System.out.println("Sortiranje grupe knjiga po godini izdavanja: ");
		prvaGrupa.getKnjige().stream()
							.sorted(Comparator.comparingInt(Knjiga::getGodinaIzdavanja))
							.forEach(System.out::println);									//		:: method reference ..
		
		// iz grupe knjiga trebam ISFILTRIRATI(filter) sve one knjige iz zanra PUTOPIS		--imam stream i treba mi njegov (pod)stream
		System.out.println("Sumiranje.. ");
		int suma;
		suma = prvaGrupa.getKnjige().stream()
							.filter(knjiga -> knjiga.getZanr() == Zanr.PUTOPIS && knjiga.getGodinaIzdavanja() % 3 == 0)
							.mapToInt(Knjiga::getGodinaIzdavanja)	//	ZAPAMTI, kod STREAM-ova, za SUMIRANJE u int/double koristiš	mapToInt ili mapToDouble metode!!
							.sum();
		System.out.println("Suma: " + suma);
		
		System.out.println("Najkraci naslov: ");
		prvaGrupa.getKnjige().stream()
			.min(Comparator.comparingInt(knjiga -> knjiga.getNaslov().length()))
			.ifPresent(knjiga -> System.out.println("Najkraci naslov: " + knjiga.getNaslov()));
		
		System.out.println("Najduzi naslov: ");
		prvaGrupa.getKnjige().stream()
			.max(Comparator.comparingInt(knjiga -> knjiga.getNaslov().length()))
			.ifPresent(knjiga -> System.out.println("Najduzi naslov: " + knjiga.getNaslov()));
	}
}

/*
	Razlika između deklaracije `Set<Knjiga> knjige = new HashSet<>();` i `HashSet<Knjiga> knjige = new HashSet<Knjiga>();` leži u nivou apstrakcije i fleksibilnosti korišćenja.

### 1. `Set<Knjiga> knjige = new HashSet<>();`

**Prednosti:**

- **Apstrakcija**: Korišćenjem interfejsa `Set`, kod postaje fleksibilniji. Ako kasnije odlučite da promenite implementaciju kolekcije (na primer, u `TreeSet` ili `LinkedHashSet`), možete to učiniti jednostavno tako što promenite inicijalizaciju objekta, bez potrebe za menjanje ostatka koda koji koristi tu kolekciju.
- **Fleksibilnost**: Omogućava vam da iskoristite različite implementacije seta bez promene ostatka koda.

```java
Set<Knjiga> knjige = new HashSet<>();
// Kasnije možete promeniti u:
// Set<Knjiga> knjige = new TreeSet<>();
// ili
// Set<Knjiga> knjige = new LinkedHashSet<>();
```

### 2. `HashSet<Knjiga> knjige = new HashSet<Knjiga>();`

**Prednosti:**

- **Specifičnost**: Jasno je da se koristi konkretna implementacija `HashSet`. Ovo može biti korisno ako želite da iskoristite specifične metode ili karakteristike `HashSet` klase koje nisu definisane u `Set` interfejsu.
- **Izvođenje specifičnih operacija**: Ako koristite metode specifične za `HashSet`, kao što su one koje nisu deo `Set` interfejsa, potrebna vam je konkretna deklaracija.

```java
HashSet<Knjiga> knjige = new HashSet<>();
```

### Preporuka

U većini slučajeva, preporučuje se korišćenje interfejsa (`Set` u ovom slučaju) za deklaraciju promenljive, jer to pruža veću fleksibilnost i omogućava lakšu promenu implementacije u budućnosti. Korišćenje konkretne klase (`HashSet`) za deklaraciju bi trebalo da bude rezervisano za situacije gde su potrebne specifične funkcionalnosti te klase.

### Kratak primer

Evo primera koji pokazuje prednost korišćenja interfejsa:

```java
Set<Knjiga> knjige = new HashSet<>();
// Kasnije možete promeniti u:
knjige = new TreeSet<>();
```

Ako koristite konkretne klase:

```java
HashSet<Knjiga> knjige = new HashSet<>();
// Promena implementacije bi zahtevala izmene u deklaraciji promenljive i svim mestima u kodu gde se koristi ta promenljiva.
```

Dakle, upotreba interfejsa u deklaraciji promenljive (`Set<Knjiga>`) je općenito bolja praksa jer pruža fleksibilnost i omogućava lakše održavanje koda.



*/