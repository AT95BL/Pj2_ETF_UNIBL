
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.*;
import java.util.HashMap;

public class Main
{
	public static void main(String[]args)
	{
		ArrayList<String> rijeci=new ArrayList<>(Arrays.asList("baba","misevi","tata","mecku"));
		/*RadSaFajlovima.pronadjiRijecUFajlovima(rijeci,Paths.get("C:\\Users\\pc\\Desktop\\PJ2backup\\Rokovi\\PJ2-06-10-2021\\Zad2\\test1.txt"),
				Paths.get("C:\\Users\\pc\\Desktop\\PJ2backup\\Rokovi\\PJ2-06-10-2021\\Zad2\\test2.txt"));*/
		//RadSaFajlovima.prebrojRijeci(Paths.get("C:\\Users\\pc\\Desktop\\PJ2backup\\Rokovi\\PJ2-06-10-2021\\Zad2\\test2.txt"));
		HashMap<String,String> rijecnik=new HashMap<>();
		rijecnik.put("mecku","bmw"); 
		rijecnik.put("cerku","kcerku"); 
		rijecnik.put("nemam","imam");
		RadSaFajlovima.zamjeniUFajlu(Paths.get("C:\\Users\\pc\\Desktop\\PJ2backup\\Rokovi\\PJ2-06-10-2021\\Zad2\\test2.txt"),rijecnik);
	}
}