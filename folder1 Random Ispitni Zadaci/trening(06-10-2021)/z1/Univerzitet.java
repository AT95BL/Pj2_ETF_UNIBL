
import java.util.*;
import java.nio.file.*;

public class Univerzitet{
	String nazivUniverziteta;
	Path folderPath;
	public ArrayList<Fakultet> fakulteti=new ArrayList<>();

	// Constructor
	public Univerzitet(String nazivUniverziteta, Path folderPath){
		this.nazivUniverziteta=nazivUniverziteta;
		this.folderPath=folderPath;
	}

	public void dodajFakultet(Fakultet f){
		this.fakulteti.add(f);
	}
}