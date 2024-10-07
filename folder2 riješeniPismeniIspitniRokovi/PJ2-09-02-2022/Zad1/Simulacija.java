

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.nio.file.*;
import java.io.*;

public class Simulacija
{
	public static String[]map=new String[1];
	public static int SansaZaPrevrtanje=25;
	
	private static final String VOZILA_PATH="Vozila.txt";
	private static final String MAPA_PATH="Mapa.txt";
	
	public ArrayList<Vozilo> vozila;
	
	public Simulacija()throws IOException
	{
		VoziloParser voziloParser=new VoziloParser(Paths.get(VOZILA_PATH));
		MapParser mapParser=new MapParser(Paths.get(MAPA_PATH));
		this.vozila=voziloParser.importFile();
		map=mapParser.importFile().toArray(map);
	}
	
	public static void main(String[]args)
	{
		Simulacija sim=null;
		try
		{
			sim=new Simulacija();
		}
		catch(IOException e)
		{
			System.out.println("Greska priliko ocitavanja fajlova za simulaciji!!");
			return;
		}
		for(var el:sim.vozila)
			el.start();
		for(var el:sim.vozila)
		{
			try
			{
				el.join();
			}
			catch(InterruptedException e)
			{
				System.out.println("PREKID!!");
			}
		}
		Collections.sort(sim.vozila,(a,b)->(int)a.getVrijemeKretanja()-(int)b.getVrijemeKretanja());
		System.out.println("Vrijeme kretanja vozila:");
		sim.vozila.forEach((v)->{System.out.println("Vozilo"+v.id+" je zavrsilo kretanja za vrijeme "+v.getVrijemeKretanja());});
		System.out.println("Rang lista:");
		int br=1;
		for(int i=0;i<sim.vozila.size();i++)
			if(sim.vozila.get(i).zavrsio)
				System.out.println("Vozilo "+sim.vozila.get(i).id+" je zavrsila trku za vrijeme:"+sim.vozila.get(i).getVrijemeKretanja()+" na poziciji "+(br++));
		var rez=sim.vozila.stream().mapToLong(Vozilo::getVrijemeKretanja).average();
		System.out.println("Prosjecno vrijeme kretanja:"+rez.getAsDouble());
	}
}