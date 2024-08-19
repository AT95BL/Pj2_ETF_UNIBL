
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.ArrayList;

public class Finder implements FileVisitor<Path> {

    ArrayList<Path> pronadjeniFajlovi = new ArrayList<>();
    String ciljniDirektorijum;
    String ekstenzija;

    // Constructor
    public Finder(String ciljniDirektorijum, String ekstenzija) {
        this.ciljniDirektorijum = ciljniDirektorijum;
        this.ekstenzija = ekstenzija;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        find(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public void find(Path putanja) {
        if (putanja.getFileName().toString().endsWith(this.ekstenzija)) {
            pronadjeniFajlovi.add(putanja);
        }
    }

    public int getNumOfMatchedFiles() {
        return this.pronadjeniFajlovi.size();
    }

    public void kopirajFajlove() {
        for (var putanjaFajlaKojiKopiramo : this.pronadjeniFajlovi) {		//	selekcija fajla koji kopiramo..
            try {
                Path destinacija = Paths.get(this.ciljniDirektorijum, putanjaFajlaKojiKopiramo.getFileName().toString());	//	pravimo putanju za taj fajl koji kopiramo..
                Files.copy(putanjaFajlaKojiKopiramo, destinacija, StandardCopyOption.REPLACE_EXISTING);						//	vršimo kopiranje..
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
