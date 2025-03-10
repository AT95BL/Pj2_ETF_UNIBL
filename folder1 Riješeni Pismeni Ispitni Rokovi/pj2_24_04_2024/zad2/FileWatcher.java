import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.*;

public class FileWatcher implements Runnable {
    private final WatchService watcher;
    private final Path rootPath;
    public static long UKUPAN_BROJ_SAMOGLASNIKA = 0;

    public FileWatcher(Path rootPath, int n) throws IOException {
        this.rootPath = rootPath;
        this.watcher = FileSystems.getDefault().newWatchService();

        // Registracija svih direktorijuma za praćenje
        for (int i = 1; i <= n; i++) {  
            Path direktorijumKojiPratimo = rootPath.resolve(String.valueOf(i));
            direktorijumKojiPratimo.register(watcher, ENTRY_CREATE);
        }
    }

    @Override
    public void run() {
        System.out.println("Praćenje promena započeto...");

        while (true) {
            WatchKey key;
            try {
                key = watcher.take(); // Čeka promene
            } catch (InterruptedException e) {
                System.out.println("FileWatcher prekinut.");
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                if (kind == ENTRY_CREATE) {
					Path fileName = (Path) event.context();
					Path dirPath = (Path) key.watchable(); // Direktan direktorijum u kojem se desila promena
					Path fullPath = dirPath.resolve(fileName);

				if (fileName.toString().endsWith(".txt")) {
					System.out.println("Dodana datoteka: " + fullPath);

					long brojac = brojacSamoglasnikaUDatoteci(fullPath);
					UKUPAN_BROJ_SAMOGLASNIKA += brojac;

					System.out.println("Broj samoglasnika: " + brojac + " u datoteci: " + fullPath);
					System.out.println("Ukupan broj samoglasnika do sada: " + UKUPAN_BROJ_SAMOGLASNIKA);
				}
}

            }

            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
	
	public long brojacSamoglasnikaUDatoteci(Path putanjaDatoteke) {
        long brojac = 0;

        try {
            List<String> sveLinijeDatoteke = Files.readAllLines(putanjaDatoteke);

            for (String linijaDatoteke : sveLinijeDatoteke) {
                for (char c : linijaDatoteke.toLowerCase().toCharArray()) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        brojac++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom čitanja datoteke: " + putanjaDatoteke);
			e.printStackTrace();
        }

        return brojac;
    }
}
