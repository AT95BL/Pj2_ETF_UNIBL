import java.io.IOException;         // Importuje klasu IOException za rukovanje mogućim izuzecima
import java.nio.file.FileSystem;    // Importuje FileSystem klasu iz java.nio.file paketa
import java.nio.file.FileSystems;   // Importuje FileSystems klasu iz java.nio.file paketa
import java.nio.file.Path;          // Importuje Path klasu iz java.nio.file paketa
import java.nio.file.Paths;         // Importuje Paths klasu iz java.nio.file paketa
import java.nio.file.StandardWatchEventKinds;  // Importuje StandardWatchEventKinds klasu iz java.nio.file paketa
import java.nio.file.WatchEvent;               // Importuje WatchEvent klasu iz java.nio.file paketa
import java.nio.file.WatchKey;                 // Importuje WatchKey klasu iz java.nio.file paketa
import java.nio.file.WatchService;             // Importuje WatchService klasu iz java.nio.file paketa
// import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Kreira novi WatchService koji prati događaje na fajl sistemu
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Definiše putanju direktorijuma koji će biti nadziran
        Path directory = Paths.get("C:\\Users\\Korisnik.DESKTOP-JVOQTMK\\Desktop\\pj2_06_10_2021\\1watchService");

        // Registruje direktorijum za praćenje događaja kreiranja, modifikacije i brisanja fajlova
        WatchKey watchKey = directory.register(watchService, 
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_MODIFY,
            StandardWatchEventKinds.ENTRY_DELETE);

        // Beskonačna petlja za obradu događaja
        while (true) {
            // Prolazi kroz sve događaje koji su se desili na nadziranom direktorijumu
            for(WatchEvent<?> event : watchKey.pollEvents()) {
                // Ispisuje tip događaja (kreiranje, modifikacija, brisanje)
                System.out.println(event.kind());
                // Dobija putanju fajla koji je izazvao događaj
                Path file = directory.resolve((Path) event.context());
                // Ispisuje putanju fajla i vreme poslednje modifikacije
                System.out.println(file + " was last modified at " + file.toFile().lastModified());
            }
        }
    }
}
