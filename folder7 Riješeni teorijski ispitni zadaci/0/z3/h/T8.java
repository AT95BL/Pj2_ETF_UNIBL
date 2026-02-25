public class T8 {
public static void main(String[] args) {
String array[] = { "a", "qwerty", "abc", "def", "test" };
Arrays.sort(array, new MyComparator());
for (String e : array) {
System.out.print(e);
}
}
}
class MyComparator implements Comparator<String> {
@Override
public int compare(String s1, String s2) {
return s2.compareTo(s1);
}
}

/*
 * U ovom kodu koristiš prilagođeni komparator da promeniš način na koji se sortira niz stringova. Evo kako funkcioniše:

### Objašnjenje koda:

1. **Kreiranje niza stringova**:
   ```java
   String array[] = { "a", "qwerty", "abc", "def", "test" };
   ```
   Niz sadrži sledeće elemente: `"a"`, `"qwerty"`, `"abc"`, `"def"`, `"test"`.

2. **Sortiranje pomoću `MyComparator`**:
   ```java
   Arrays.sort(array, new MyComparator());
   ```
   Ovaj poziv koristi klasu `MyComparator` kao prilagođeni komparator da sortira elemente niza. Umesto default sortiranja (koje bi bilo abecedno u rastućem redosledu),
   koristiš **obrnuti redosled** definisan u `MyComparator`.

3. **Implementacija `MyComparator`**:
   ```java
   class MyComparator implements Comparator<String> {
       @Override
       public int compare(String s1, String s2) {
           return s2.compareTo(s1); // Obrnuto poređenje
       }
   }
   ```
   - **`compare(String s1, String s2)`**: Ova metoda poredi dva stringa, ali umesto da koristi standardno poređenje (`s1.compareTo(s2)`), 
    koristi obrnuto poređenje (`s2.compareTo(s1)`).
   - Ovo znači da će stringovi biti sortirani u **silaznom redosledu** (od najvećeg ka najmanjem), na osnovu njihovog leksičkog poređenja (abecednog).

4. **Ispis sortiranih elemenata**:
   ```java
   for (String e : array) {
       System.out.print(e);
   }
   ```
   - Nakon sortiranja, ovaj deo koda ispisuje sve elemente niza redom.

### Redosled operacija:
- Originalni niz pre sortiranja:
  ```
  ["a", "qwerty", "abc", "def", "test"]
  ```

- Prilikom sortiranja u **silaznom redosledu** prema poređenju stringova (`s2.compareTo(s1)`):
  - Najveći string (u smislu leksičkog poređenja) je `"test"`, zatim slede `"qwerty"`, `"def"`, `"abc"`, i na kraju `"a"`.
  
- Sortirani niz izgleda ovako:
  ```
  ["test", "qwerty", "def", "abc", "a"]
  ```

### Konačni ispis:
```
testqwertydefabca
```

### Rezime:
- **`MyComparator`** sortira stringove u silaznom abecednom redosledu (suprotno od prirodnog rastućeg poređenja).
- Rezultat `Arrays.sort(array, new MyComparator())` je da niz bude sortiran od "najvećeg" stringa prema "najmanjem".
 * 
 * 
 */