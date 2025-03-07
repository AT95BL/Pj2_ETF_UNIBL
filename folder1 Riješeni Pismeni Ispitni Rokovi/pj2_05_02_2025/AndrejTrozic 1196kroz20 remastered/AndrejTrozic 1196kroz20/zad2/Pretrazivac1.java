
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pretrazivac1 {

    private final String ekstenzija;
    private final List<Path> pronadjeniFajlovi = new ArrayList<>();
    private int ukupanBrojFajlova = 0;

    public Pretrazivac1(String ekstenzija) {
        this.ekstenzija = ekstenzija;
    }

    public void pretraziDirektorijum(Path putanja) throws IOException {
        Files.walk(putanja)
                .filter(Files::isRegularFile)
                .forEach(this::procesuirajDatoteku);
    }

    private void procesuirajDatoteku(Path datoteka) {
        ukupanBrojFajlova++;
        if (datoteka.toString().endsWith(ekstenzija)) {
            pronadjeniFajlovi.add(datoteka);
        }
    }

    public void ispisiRezultate(Path direktorijum) throws IOException {
        Path izlaznaDatoteka = direktorijum.resolve("rezultati.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(izlaznaDatoteka, StandardCharsets.UTF_8)) {
            for (Path fajl : pronadjeniFajlovi) {
                writer.write(fajl.toAbsolutePath().toString());
                writer.newLine();
            }
            writer.write("Ukupan broj pronađenih fajlova: " + pronadjeniFajlovi.size());
            writer.newLine();
            writer.write("Ukupan broj svih fajlova: " + ukupanBrojFajlova);
            writer.newLine();
            double procenat = ukupanBrojFajlova > 0 ? (double) pronadjeniFajlovi.size() / ukupanBrojFajlova * 100 : 0;
            writer.write("Procenat pronađenih fajlova: " + procenat + "%");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 1) {
            System.err.println("Potrebno je proslediti ekstenziju kao argument komandne linije.");
            return;
        }

        String ekstenzija = args[0];
        Pretrazivac1 pretrazivac = new Pretrazivac1(ekstenzija);

        List<Path> putanjeDoFoldera = ucitajPutanjeIzFajla("putanje.txt"); // Kreiraj datoteku "putanje.txt" sa putanjama do foldera

        ExecutorService executor = Executors.newFixedThreadPool(putanjeDoFoldera.size());

        for (Path putanja : putanjeDoFoldera) {
            executor.submit(() -> {
                try {
                    pretrazivac.pretraziDirektorijum(putanja);
                    pretrazivac.ispisiRezultate(putanja);
                } catch (IOException e) {
                    System.err.println("Greška prilikom pretrage foldera " + putanja + ": " + e.getMessage());
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Pretraga završena.");
    }

    private static List<Path> ucitajPutanjeIzFajla(String nazivFajla) throws IOException {
        List<Path> putanje = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(nazivFajla), StandardCharsets.UTF_8)) {
            String linija;
            while ((linija = reader.readLine()) != null) {
                putanje.add(Paths.get(linija));
            }
        }
        return putanje;
    }
}

/* 
    javac Pretrazivac.java

    jar cfm manifest.txt pretrazivac.jar *.class

    java -jar pretrazivac.jar .txt
*/