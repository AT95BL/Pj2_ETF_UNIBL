import java.util.ArrayList;
import java.nio.file.Path;

public class Univerzitet{
	public String imeUniverziteta;
	public Path folderPath;
	public ArrayList<Fakultet> fakulteti=new ArrayList<Fakultet>();
	
	public Univerzitet(String imeUniverziteta,Path folderPath){
		this.imeUniverziteta=imeUniverziteta;
		this.folderPath=folderPath;
	}
	
	public void dodajFakultet(Fakultet s){
		this.fakulteti.add(s);
	}
}
