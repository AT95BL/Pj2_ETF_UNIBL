import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.awt.Desktop;

public class Pretraga implements FileVisitor<Path> {
    Path putanjaDoPocetnogDirektorijuma = null;
    String tekstZaPretragu = "";
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Pretraga() {}

    // Constructor
    public Pretraga(Path putanjaDoPocetnogDirektorijuma, String tekstZaPretragu) {
        this.putanjaDoPocetnogDirektorijuma = putanjaDoPocetnogDirektorijuma;
        this.tekstZaPretragu = tekstZaPretragu;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path putanjaDirektorij, IOException nebitno) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path putanjaDirektorij, BasicFileAttributes nebitno) throws IOException {
        return FileVisitResult.CONTINUE;
    }

		public void find(Path putanjaDatoteka) {
			boolean rezultat = false;

			// Provera imena fajla
			if (putanjaDatoteka.getFileName().toString().toLowerCase().contains(tekstZaPretragu.toLowerCase())) {
				System.out.println("'" + tekstZaPretragu + "' pronađen u imenu fajla: " + putanjaDatoteka);
				rezultat = true;
			}

			// Čitanje sadržaja fajla
			List<String> sveLinijeUDatoteci = null;
			try {
				sveLinijeUDatoteci = Files.readAllLines(putanjaDatoteka, StandardCharsets.UTF_8);
			} catch (IOException ex) {
				System.out.println("Nije moguće pročitati fajl: " + putanjaDatoteka);
				return; // Prekida pretragu za ovaj fajl.
			}

			// Pretraga u sadržaju fajla
			int brojLinije = 1;
			for (String linijaDatoteke : sveLinijeUDatoteci) {
				if (linijaDatoteke.toLowerCase().contains(tekstZaPretragu.toLowerCase())) {
					int indeks = linijaDatoteke.toLowerCase().indexOf(tekstZaPretragu.toLowerCase());
					System.out.println("Tekst pronađen u fajlu: " + putanjaDatoteka);
					System.out.println("Linija: " + brojLinije + ", indeks: " + indeks);
					rezultat = true;
					break;
				}
				brojLinije++;
			}

			// Ako je pronađen rezultat, otvori fajl u uređivaču
			if (rezultat) {
				try {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.EDIT)) {
						desktop.edit(new File(putanjaDatoteka.toString()));
					}
				} catch (IOException ex) {
					System.out.println("Nije moguće otvoriti fajl: " + putanjaDatoteka);
				}
			}
		}

    @Override
    public FileVisitResult visitFile(Path putanjaDatoteka, BasicFileAttributes nebitno) throws IOException {
        find(putanjaDatoteka);

        System.out.println("Nastavi pretragu [DA/NE]: ");
        String line = scanner.nextLine();

        if ("DA".equalsIgnoreCase(line)) {
            return FileVisitResult.CONTINUE;
        }

        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path putanjaDatoteka, IOException nebitno) throws IOException {
        System.out.println("Neuspešno čitanje fajla: " + putanjaDatoteka);
        return FileVisitResult.CONTINUE;
    }
}
