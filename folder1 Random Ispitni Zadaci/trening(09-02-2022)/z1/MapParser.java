
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;

public class MapParser extends Parser<String>{
	
	// Constructor
	public MapParser(Path path){
		super(path);
	}
	
	@Override
	public ArrayList<String> importFromFile()throws IOException{
		ArrayList<String> listaMestonica=new ArrayList<>();
		
		List<String> sveLinijeDatoteke=null;
		try{
			sveLinijeDatoteke=this.procitajSveLinijeDatoteke();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		String[] sveRijeciJedneLinijeDatoteke=this.procitajSveRijeciJedneLinijeDatoteke(sveLinijeDatoteke.get(0), "-");
		listaMestonica.addAll(Arrays.asList(sveRijeciJedneLinijeDatoteke));
		return listaMestonica;
	}
}