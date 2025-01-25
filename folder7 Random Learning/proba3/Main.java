
import java.util.Scanner;
// import java.io.Serializable;
import java.io.*;
import java.nio.file.*;

public class Main implements Serializable{
	public static void main(String[] args){

		Scanner scanner=new Scanner(System.in);
		User user=new User();
		String line;
		Path path;

		System.out.println("Seralization Folder Path: ");
		line=scanner.nextLine();
		path=Paths.get(line);
		try{
			ObjectOutputStream output=new ObjectOutputStream(
				new FileOutputStream(path.toString()+File.separator+"user.ser"));
			output.writeObject(user);
			output.flush();
			output.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

		// Deserializacija objekta iz fajla
		System.out.println("Deseralization Folder Path: ");
		line=scanner.nextLine();
		path=Paths.get(line);
        try (ObjectInputStream input = new ObjectInputStream(
        		new FileInputStream(path.toString()+File.separator+"user.ser"))) {
            user = (User) input.readObject();  // Deserializacija objekta
            System.out.println("Deserijalizovani objekat: " + user);  // Ispisuje objekat (poziva toString())
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
	}
}