
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class T5 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(100, 200, 30, 10, 20, 50, 100, 400, 200, 500, 300);
Optional<Integer> result = numbers.stream().distinct().
filter(e -> e > 100).reduce((a, b) -> a + b);
System.out.println(result.get());
numbers.stream().distinct().sorted().
collect(Collectors.toList()).forEach(System.out::println);
Stream.iterate(2, e -> e + 2).peek(e -> {
System.out.print("peek");
}).limit(20).forEach(System.out::println); // nekada se za limit zna desiti "5" umjesto "20" ..ako se sjećam..
}
}

/*
1400
10
20
30
50
100
200
300
400
500
peek2
peek4
peek6
peek8
peek10
peek12
peek14
peek16
peek18
peek20
peek22
peek24
peek26
peek28
peek30
peek32
peek34
peek36
peek38
peek40




Evo kako se ponaša dati kod i zašto dobijaš navedeni ispis:

### Prvi deo koda: **Suma brojeva većih od 100**
```java
Optional<Integer> result = numbers.stream()
    .distinct()
    .filter(e -> e > 100)
    .reduce((a, b) -> a + b);
System.out.println(result.get());
```

1. **`numbers.stream()`**: Kreira stream od liste brojeva `numbers = Arrays.asList(100, 200, 30, 10, 20, 50, 100, 400, 200, 500, 300);`.

2. **`distinct()`**: Uklanja duplikate u listi. Nakon ovog koraka, lista izgleda ovako:
   ```
   [100, 200, 30, 10, 20, 50, 400, 500, 300]
   ```

3. **`filter(e -> e > 100)`**: Zadržava samo brojeve veće od 100, pa filtrirana lista postaje:
   ```
   [200, 400, 500, 300]
   ```

4. **`reduce((a, b) -> a + b)`**: Suma brojeva iz filtrirane liste. Rezultat je:
   ```
   200 + 400 + 500 + 300 = 1400
   ```

Dakle, prva linija ispisa je:
```
1400
```

### Drugi deo koda: **Sortiranje i ispis distinct elemenata**
```java
numbers.stream().distinct().sorted()
    .collect(Collectors.toList())
    .forEach(System.out::println);
```

1. **`distinct()`**: Opet uklanja duplikate, pa lista izgleda ovako:
   ```
   [100, 200, 30, 10, 20, 50, 400, 500, 300]
   ```

2. **`sorted()`**: Sortira listu u prirodnom redosledu (rastućem poretku):
   ```
   [10, 20, 30, 50, 100, 200, 300, 400, 500]
   ```

3. **`forEach(System.out::println)`**: Ispisuje svaki element redom, što daje sledeći ispis:
   ```
   10
   20
   30
   50
   100
   200
   300
   400
   500
   ```

### Treći deo koda: **Generisanje i ispis parnih brojeva**
```java
Stream.iterate(2, e -> e + 2)
    .peek(e -> { System.out.print("peek"); })
    .limit(20)
    .forEach(System.out::println);
```

1. **`Stream.iterate(2, e -> e + 2)`**: Generiše beskonačan stream koji počinje od `2` i svakim korakom dodaje `2`. Tako će generisati brojeve: 2, 4, 6, 8, 10, itd.

2. **`peek(e -> System.out.print("peek"))`**: Za svaki generisani broj, `peek` će ispisati `"peek"` pre nego što ispiše vrednost broja.
 Ovo je korisno za "špijuniranje" unutar stream-a.

3. **`limit(20)`**: Ograničava stream na prvih 20 brojeva.

4. **`forEach(System.out::println)`**: Ispisuje svaki broj na novoj liniji.

Konačni ispis iz ovog dela koda je:
```
peek2
peek4
peek6
peek8
peek10
peek12
peek14
peek16
peek18
peek20
peek22
peek24
peek26
peek28
peek30
peek32
peek34
peek36
peek38
peek40
```

### Konačni ispis celog programa:
```
1400
10
20
30
50
100
200
300
400
500
peek2
peek4
peek6
peek8
peek10
peek12
peek14
peek16
peek18
peek20
peek22
peek24
peek26
peek28
peek30
peek32
peek34
peek36
peek38
peek40
```









Ako promeniš `limit(20)` u `limit(5)` u trećem delu koda, izvršiće se samo za prvih 5 elemenata generisanih iz stream-a. Evo kako će izgledati ispis i objašnjenje:

### Modifikovani deo koda:
```java
Stream.iterate(2, e -> e + 2)
    .peek(e -> { System.out.print("peek"); })
    .limit(5)
    .forEach(System.out::println);
```

- **`Stream.iterate(2, e -> e + 2)`**: Generiše beskonačan stream počevši od `2`, zatim `4`, `6`, `8`, itd.
- **`peek(e -> System.out.print("peek"))`**: Pre svakog ispisanog broja, dodaje `"peek"`.
- **`limit(5)`**: Ograničava stream na prvih 5 brojeva (2, 4, 6, 8, 10).
- **`forEach(System.out::println)`**: Ispisuje svaki broj na novoj liniji.

### Očekivani ispis:

Prva dva dela koda ostaju ista, pa je ispis tih delova:

```
1400
10
20
30
50
100
200
300
400
500
```

Treći deo koda sada ograničava ispis na prvih 5 parnih brojeva, tako da ispisuje:

```
peek2
peek4
peek6
peek8
peek10
```

### Konačni ispis celog programa sa `limit(5)`:
```
1400
10
20
30
50
100
200
300
400
500
peek2
peek4
peek6
peek8
peek10
```










*/