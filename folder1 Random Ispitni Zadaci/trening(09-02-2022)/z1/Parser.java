
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public abstract class Parser<T>{
	Path path;
	
	// Constructor
	public Parser(Path path){
		this.path=path;
	}
	
	// procitaces objekte iz datoteke, napravices ArrayList<T> tih objekata, metoda ti na kraju vraca referencu na tu istu listu ..
	public abstract ArrayList<T> importFromFile()throws IOException;
	
	List<String> procitajSveLinijeDatoteke()throws IOException{
		return Files.readAllLines(this.path);
	}
	
	String[] procitajSveRijeciJedneLinijeDatoteke(String jednaLinijaDatoteke, String delimiter){
		return jednaLinijaDatoteke.split(delimiter);
	}
}
