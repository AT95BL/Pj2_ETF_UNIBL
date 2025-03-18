import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class HiddenFileFinder {
    private static int hiddenFileCount = 0;
    private static int totalFileCount = 0;
    private static BufferedWriter writer;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Korišćenje: java -jar HiddenFileFinder.jar <putanja do foldera>");
            return;
        }

        Path rootFolder = Paths.get(args[0]);
        if (!Files.exists(rootFolder) || !Files.isDirectory(rootFolder)) {
            System.out.println("Greška: Unesena putanja nije validan direktorijum!");
            return;
        }

        Path outputFile = rootFolder.resolve("hidden_files.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer = bw;
            Files.walkFileTree(rootFolder, new HiddenFileVisitor());
            double percentage = (totalFileCount > 0) ? (hiddenFileCount * 100.0 / totalFileCount) : 0;
            
            writer.write("\n--- Statistika ---\n");
            writer.write("Ukupan broj fajlova: " + totalFileCount + "\n");
            writer.write("Ukupan broj skrivenih fajlova: " + hiddenFileCount + "\n");
            writer.write(String.format("Procenat skrivenih fajlova: %.2f%%\n", percentage));

            System.out.println("Pretraga završena! Rezultati su u: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HiddenFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFileCount++;
            if (Files.isHidden(file)) {
                hiddenFileCount++;
                writer.write(file.toAbsolutePath().toString());
                writer.newLine();
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
