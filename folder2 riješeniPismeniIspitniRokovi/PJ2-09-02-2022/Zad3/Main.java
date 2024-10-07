
import java.nio.file.*;
import java.io.*;

public class Main
{
	public static void main(String[]args)throws IOException
	{
		if(args.length!=3)
		{
			System.out.println("Nedovoljan broj argumeneta!!");
			return;
		}
		Path path=Paths.get(args[0]);
		Finder finder=new Finder(path,args[1],args[2]);
		Files.walkFileTree(path,finder);
		System.out.println("Rezultati pretrage:");
		finder.map.entrySet().forEach((s)->{System.out.println(s.getKey()+"-"+s.getValue());});
		
	}
}