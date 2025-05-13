
public class T2 {
public static void main(String arg[]) {
int i = 8; // nekad = 8, nekad = 4
for (; i <= 12; i+=2) {
i += i++;
i -= 1;
i++;
i += 1;
i = i++;
}
System.out.println(--i);
}
}

// ako je na početku i=4  tada je ispis 24
// ako je na početku i=8, tada je ispis 18

/* 
U ovom kodu dolazi do nekoliko manipulacija sa promenljivom `i` unutar `for` petlje, što dovodi do zbunjujućih rezultata zbog efekata **post-inkrementa** (`i++`) i kombinacije operacija nad `i`. Evo detaljnog objašnjenja zašto ispisuješ 24:

### Kod Analiza
```java
int i = 4;
for (; i <= 12; i+=2) {
    i += i++;  // Post-increment: vrednost i je korišćena, a zatim uvećana
    i -= 1;    // Smanjuje vrednost i za 1
    i++;       // Povećava i za 1
    i += 1;    // Dodaje 1 na i
    i = i++;   // Vraća trenutnu vrednost i, a zatim je uvećava
}
System.out.println(--i);  // Smanjuje i za 1 pre ispisa
```

### Detaljno objašnjenje
1. **Inicijalizacija**:
   - `i = 4` je inicijalna vrednost.
   
2. **Prva iteracija** (`i = 4`):
   - `i += i++`: `i` postaje `8`, jer prvo koristi vrednost `i` (4) i dodaje je na `i` (4 + 4 = 8), a zatim uvećava `i` na `5`, ali to nema uticaja jer je `i += i++` već promenio `i` na `8`.
   - `i -= 1`: `i` postaje `7`.
   - `i++`: `i` postaje `8`.
   - `i += 1`: `i` postaje `9`.
   - `i = i++`: `i` ostaje `9` jer koristi trenutnu vrednost `i` pre uvećanja (post-inkrement nema efekta jer se vrednost vraća pre uvećanja).

3. **Inkrement for petlje**: Na kraju iteracije, `i+=2`, pa sada `i = 11`.

4. **Druga iteracija** (`i = 11`):
   - `i += i++`: `i` postaje `22`, jer prvo koristi vrednost `i` (11), dodaje je na `i` (11 + 11 = 22), a zatim uvećava `i` na `12`, ali taj post-inkrement opet nema uticaj jer je `i += i++` već promenio vrednost `i` na `22`.
   - `i -= 1`: `i` postaje `21`.
   - `i++`: `i` postaje `22`.
   - `i += 1`: `i` postaje `23`.
   - `i = i++`: `i` ostaje `23` iz istog razloga kao ranije (post-inkrement vraća trenutnu vrednost pre uvećanja).

5. **Inkrement for petlje**: `i+=2`, sada je `i = 25`.

6. **Izlaz iz petlje**: Pošto je `i = 25`, a uslov petlje je `i <= 12`, petlja se prekida.

7. **Konačni ispis**:
   - `System.out.println(--i);`: Pre ispisa se vrednost `i` smanjuje za 1, pa postaje `24`.

### Zaključak
Zbog svih manipulacija i efekata post-inkrementa, na kraju dobijaš vrednost `24`.
*/