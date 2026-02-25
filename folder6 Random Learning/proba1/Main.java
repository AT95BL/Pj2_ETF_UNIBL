
public class Main{
	public static void main(String[] args){
		Integer integer = 5;
		int i=10;
		
		// Number n=20;
		
		System.out.println(integer + i /*+ n*/);
	}
}

/*
Program se uspešno izvršava zbog mehanizma u Javi koji se zove **autoboxing** i **unboxing**.

- **Autoboxing** je automatsko pretvaranje primitivnog tipa (npr. `int`) u odgovarajući wrapper tip (npr. `Integer`).
- **Unboxing** je obrnuti proces, automatsko pretvaranje wrapper tipa (npr. `Integer`) u odgovarajući primitivni tip (npr. `int`).

U tvom primeru:

```java
Integer integer = 5;  // Autoboxing: '5' (int) se automatski pretvara u 'Integer'
int i = 10;           // Primitivni int

System.out.println(integer + i); // Unboxing: 'integer' (Integer) se automatski pretvara u 'int'
```

Kada se `Integer integer` koristi u izrazu `integer + i`, 
**unboxing** se automatski primenjuje, 
pretvarajući `integer` iz `Integer` tipa u `int`, 
kako bi se mogla izvršiti aritmetička operacija `+` između dva `int` tipa. 
Tako se `integer` automatski "rasklapa" u svoj primitivni oblik (`int`), omogućavajući zbir `integer + i`.

Rezultat je 15, a program se izvršava bez greške.

public class Main {
    public static void main(String[] args) {
        Integer integer = 5;
        int i = 10;

        Number n = 20;

        System.out.println(integer + i + n.intValue()); // Pretvaranje u int
    }
}

*/