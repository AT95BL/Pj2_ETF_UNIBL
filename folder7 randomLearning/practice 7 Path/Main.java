
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Unesite putanju: ");
		String line = scanner.nextLine();
		
		Path path = Paths.get(line);
		System.out.println(path);
	}
}

/*
	U Javi, manipulacija putanjama i rad sa fajlovima je olakšan korišćenjem klase `Path` iz paketa `java.nio.file`, 
	kao i raznim pomoćnim klasama iz istog paketa, kao što su `Files`, `Paths` i `FileSystems`.

### Osnovne klase i metode

#### 1. `Path`
Klasa `Path` predstavlja apstraktnu reprezentaciju putanje fajla ili direktorijuma.

- **Kreiranje putanje**:
  ```java
  Path path = Paths.get("C:/Users/Korisnik/Desktop/pj2Practice");
  ```

- **Dobijanje delova putanje**:
  ```java
  Path fileName = path.getFileName(); // "pj2Practice"
  Path parent = path.getParent();     // "C:/Users/Korisnik/Desktop"
  Path root = path.getRoot();         // "C:/"
  ```

- **Spajanje putanja**:
  ```java
  Path newPath = path.resolve("subfolder/file.txt");    //    ZAPAMTI DA JE TO 'resolve' METODA IZ PATH KLASE!!
  ```

- **Normalizacija putanje**:
  ```java
  Path normalizedPath = path.normalize();
  ```

- **Relativizacija putanje**:
  ```java
  Path path1 = Paths.get("C:/Users/Korisnik/Desktop");
  Path path2 = Paths.get("C:/Users/Korisnik/Desktop/pj2Practice");
  Path relativePath = path1.relativize(path2); // "pj2Practice"
  ```

#### 2. `Files`
Klasa `Files` sadrži mnogo statičkih metoda za rad sa fajlovima i direktorijumima.

- **Provera postojanja fajla ili direktorijuma**:
  ```java
  boolean exists = Files.exists(path);              //    ZAPAMTI METODU 'exists' U SLUČAJU DA TI ZATREBA SAD DA PRONAĐEŠ DIR/DAT..
  ```

- **Čitanje sadržaja fajla**:
  ```java
  List<String> lines = Files.readAllLines(path);    //  Hint: 'var' takođe radi posao..
  ```

- **Pisanje u fajl**:
  ```java
  Files.write(path, "Some content".getBytes());
  ```

- **Kopiranje fajla**:
  ```java
  Path source = Paths.get("C:/source.txt");
  Path destination = Paths.get("C:/destination.txt");
  Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);   //  ZAPAMTI!!
  ```

- **Brisanje fajla**:
  ```java
  Files.delete(path);
  ```

- **Kreiranje direktorijuma**:
  ```java
  Files.createDirectory(Paths.get("C:/newDirectory"));
  ```

#### 3. `Paths`
Klasa `Paths` sadrži pomoćne metode za dobijanje instanci `Path`.

- **Kreiranje `Path` instance**:
  ```java
  Path path = Paths.get("C:/Users/Korisnik/Desktop/pj2Practice");
  ```

#### 4. `FileSystems`
Klasa `FileSystems` može biti korišćena za dobijanje `Path` instance koristeći `FileSystem`.

- **Dobijanje `Path` instance**:
  ```java
  Path path = FileSystems.getDefault().getPath("C:/Users/Korisnik/Desktop/pj2Practice");
  ```

### Manipulacija putanjama
Manipulacija putanjama obuhvata razne operacije kao što su spajanje putanja, relativizacija, normalizacija, itd.

- **Spajanje putanja (`resolve`)**:
  ```java
  Path basePath = Paths.get("C:/Users/Korisnik/Desktop");
  Path resolvedPath = basePath.resolve("pj2Practice/file.txt");
  ```

- **Relativizacija putanja (`relativize`)**:
  ```java
  Path path1 = Paths.get("C:/Users/Korisnik/Desktop");
  Path path2 = Paths.get("C:/Users/Korisnik/Desktop/pj2Practice");
  Path relativePath = path1.relativize(path2); // "pj2Practice"
  ```

- **Normalizacija putanje (`normalize`)**:
  ```java
  Path path = Paths.get("C:/Users/../Korisnik/Desktop/./pj2Practice");
  Path normalizedPath = path.normalize(); // "C:/Korisnik/Desktop/pj2Practice"
  ```

- **Dobijanje apsolutne putanje (`toAbsolutePath`)**:
  ```java
  Path path = Paths.get("pj2Practice/file.txt");
  Path absolutePath = path.toAbsolutePath();
  ```

### Rad sa simboličkim linkovima
`Files` klasa podržava operacije sa simboličkim linkovima.

- **Kreiranje simboličkog linka**:
  ```java
  Path link = Paths.get("C:/link");
  Path target = Paths.get("C:/target");
  Files.createSymbolicLink(link, target);
  ```

- **Čitanje simboličkog linka**:
  ```java
  Path link = Paths.get("C:/link");
  Path target = Files.readSymbolicLink(link);
  ```

### Primer: Pretraga fajlova u direktorijumu
Evo jednostavnog primera koji pretražuje fajlove sa određenom ekstenzijom u direktorijumu:

```java
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSearcher extends SimpleFileVisitor<Path> {
    private final PathMatcher matcher;

    public FileSearcher(String pattern) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (matcher.matches(file.getFileName())) {
            System.out.println("Found: " + file);
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        Path startingDir = Paths.get("C:/Users/Korisnik/Desktop");
        FileSearcher searcher = new FileSearcher("*.txt");

        try {
            Files.walkFileTree(startingDir, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Ovaj kod pretražuje fajlove sa `.txt` ekstenzijom u datom direktorijumu i njegovim poddirektorijumima.

Korišćenjem ovih klasa i metoda, možete lako manipulisati putanjama, pretraživati fajlove, kopirati fajlove i obavljati mnoge druge operacije sa fajlovima i direktorijumima u Javi.
*/