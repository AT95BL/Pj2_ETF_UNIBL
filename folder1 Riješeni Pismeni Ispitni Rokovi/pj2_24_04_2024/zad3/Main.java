import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Greška! Korišćenje: java -jar HiddenFileFinder.jar <putanja do foldera>");
            return;
        }

        Path pocetniDirektorijum = Paths.get(args[0]);

        // Proveri da li folder postoji
        if (!Files.exists(pocetniDirektorijum) || !Files.isDirectory(pocetniDirektorijum)) {
            System.out.println("Unesena putanja nije validan direktorijum!");
            return;
        }

        // Pokreni pretragu
        FileHunter fileHunter = new FileHunter(pocetniDirektorijum);
        try {
            Files.walkFileTree(pocetniDirektorijum, fileHunter);
            fileHunter.upisiPutanjeUTxtDatoteku();
            fileHunter.upisiPodatkeUTxtDatoteku();
            System.out.println("Pretraga završena! Rezultati su u: " + pocetniDirektorijum.resolve("hidden_files.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
