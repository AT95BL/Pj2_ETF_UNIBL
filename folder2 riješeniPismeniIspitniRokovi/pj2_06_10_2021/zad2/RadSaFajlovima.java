
import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.HashMap;

public class RadSaFajlovima
{
																		//	neodređen broj putanja do fajlova
	public static void pronadjiRijecUFajlovima(ArrayList<String> rijeci, Path... paths)
	{
		for(var path:paths)
		{
			try
			{
				/*
				 * 	A/B/C/D
				 *  String fileName=path.getFileName()+".search.txt";	->	"D.search.txt"
				 *  PrintWriter writer=new PrintWriter(
				 * 						new BufferedWriter(
				 * 						new FileWriter(path.getParent().toString()+File.separator+fileName)));
				 * 														->	A/B/C/(D, D.search.txt)
				 */
				String fileName=path.getFileName()+".search.txt";	//	A/B/C/D -> A/B/C/	"D.search.txt"
				PrintWriter writer = 
					new PrintWriter(new BufferedWriter(new FileWriter(path.getParent().toString()+File.separator+fileName))); 
					//	A/B/C/D -> A/B/C/D.search.txt
				List<String> lines=Files.readAllLines(path);
				for(var line:lines)
				{
					var tmp=line.split("\\W+");
					for(var rijec:tmp)
					{
						//System.out.println(rijec);
						for(var glavneRijeci:rijeci)
							if(rijec.equalsIgnoreCase(glavneRijeci))
							{
						//if(rijeci.contains(rijec))
								writer.println(line);
								break;
							}
					}
				}
				writer.flush();
				writer.close();
			}
			catch(IOException e)
			{
				System.out.println("Greska prilikom otvaranja fajla"+path);
			}
		}
	}
	
	public static void prebrojRijeci(Path path)
	{
		HashMap<String,Integer> map=new HashMap<>();
		try
		{
			List<String> lines=Files.readAllLines(path);	//	Zapamti ovu kombinaciju!!
			for(var line:lines)
			{
				var tmp=line.split("\\W+");			//	Zapamti ovaj regex '\\W+'	!!!
				for(var rijec:tmp)
					if(map.containsKey(rijec))
					{
						map.put(rijec,map.get(rijec)+1);	//	ideja mapiranje jeste (riječ=ključ, brojPonavljanjaRiječi=value)!!
					}
					else
					{
						map.put(rijec,1);
					}
			}
		}
		catch(IOException e)
		{
			System.out.println("Greska prilikom otvaranja fajla"+path);
			return;
		}
		System.out.println("Rijeci u fajlu i ponavljanja:");
		map.entrySet().forEach((s)->{System.out.println(s.getKey()+"-"+s.getValue());});
	}
	
	public static void zamjeniUFajlu(Path path,HashMap<String,String> rijecnik)
	{
		try
		{
			List<String> lines=Files.readAllLines(path);
			PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(path.toString())));
			for(var line:lines)
			{
				var tmp=line.split("\\W+");
				String novi=new String(line);
				for(var rijec:tmp)
				{
					if(rijecnik.containsKey(rijec))
						novi=novi.replaceAll("\\b"+rijec+"\\b",rijecnik.get(rijec));
				}
				writer.println(novi);
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("Greska prilikom otvaranja fajla"+path);
			return;
		}
	}
}

/*
 * `\\b` u regularnim izrazima označava **granicu riječi** (*word boundary*).

### Objašnjenje:

- **`\\b`**: Predstavlja poziciju između znaka koji se tretira kao karakter riječi (`\w`) i znaka koji se ne tretira kao karakter riječi (npr. razmaci, interpunkcija ili početak/kraj niza).

### Svrha:
Granica riječi omogućava da traženje u regularnom izrazu bude preciznije. Na primjer, ako tražiš riječ "cat" bez korištenja granice riječi, moglo bi se dogoditi da pogodiš i riječi poput "catapult" ili "concatenation". Korištenje `\\b` osigurava da ćeš pretraživati **samo cijele riječi** "cat" i izbjeći slučajna podudaranja s djelovima riječi.

### Primjer:
Ako imaš tekst:
```txt
The cat sat on the catapult.
```

Kada koristiš regularni izraz bez `\\b`:
```java
line.replaceAll("cat", "dog");
```
Zamijenit će sve pojave "cat", uključujući u riječima kao što je "catapult":
```
The dog sat on the dogapult.
```

Kada koristiš `\\b`:
```java
line.replaceAll("\\bcat\\b", "dog");
```
Zamijenit će samo cijele riječi "cat", a "catapult" će ostati nepromijenjeno:
```
The dog sat on the catapult.
```

Dakle, **`\\b` pomaže ograničiti zamjenu na cijele riječi**, bez mijenjanja djelova drugih riječi.
 */


/*
 * 	Korisna kombinacija za zapamtiti:
 * 
 * 	List<String> lines = Files.readAllLines(path);
 * 
 * 	for(var line : lines){
 * 		var tmp = line.split("\\W+");
 * 			for(var rijec:tmp){ 
 * 				..doSomething()...
 * 			}
 * 	}
 * 
 */