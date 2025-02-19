import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JavaClassGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java JavaClassGenerator <folder_path>");
            return;
        }
        File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }
        
        for (File file : Objects.requireNonNull(folder.listFiles((dir, name) -> name.endsWith(".txt")))) {
            generateJavaClass(file);
        }
    }
    
    private static void generateJavaClass(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        if (lines.isEmpty()) return;

        String className = lines.get(0).trim();
        List<String> attributes = new ArrayList<>();
        List<String> methods = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.startsWith("+")) methods.add(line.substring(1).trim());
            else attributes.add(line);
        }

        writeJavaFile(className, attributes, methods, file.getParent());
    }
    
    private static void writeJavaFile(String className, List<String> attributes, List<String> methods, String dir) throws IOException {
        File outputFile = new File(dir, className + ".java");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("public class " + className + " {\n\n");
            
            for (String attr : attributes) {
                writer.write("    private " + attr.substring(2) + ";\n");
            }
            writer.write("\n");
            
            // Constructor
            writer.write("    public " + className + "() {}\n\n");
            writer.write("    public " + className + "(" + String.join(", ", attributes.stream().map(a -> a.substring(2)).toList()) + ") {\n");
            for (String attr : attributes) {
                String name = attr.split(" ")[1];
                writer.write("        this." + name + " = " + name + ";\n");
            }
            writer.write("    }\n\n");
            
            // Getters & Setters
            for (String attr : attributes) {
                String[] parts = attr.split(" ");
                String type = parts[2];
                String name = parts[1];
                String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);

                writer.write("    public " + type + " get" + methodName + "() { return " + name + "; }\n");
                writer.write("    public void set" + methodName + "(" + type + " " + name + ") { this." + name + " = " + name + "; }\n\n");
            }
            
            // Methods
            for (String method : methods) {
                writer.write("    public void " + method + " { }\n\n");
            }
            
            writer.write("}\n");
        }
    }
}
