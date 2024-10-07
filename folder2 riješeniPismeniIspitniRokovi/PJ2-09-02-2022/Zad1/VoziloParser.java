
import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;

public class VoziloParser extends Parser<Vozilo>
{
	public VoziloParser(Path path)
	{
		super(path);
	}
	
	@Override
	public ArrayList<Vozilo> importFile()throws IOException
	{
		ArrayList<Vozilo> vozila=new ArrayList<>();
		var lines=this.getLines();
		for(var line:lines)
		{
			try
			{
				var tmp=this.getLineContent(line," ");
				if("Automobil".equals(tmp[0]))
					vozila.add(new Automobil(Integer.parseInt(tmp[1]),new Vozac(tmp[2],tmp[3]),Motor.valueOf(tmp[4]),tmp[5]));
				else if("Kamion".equals(tmp[0]))
					vozila.add(new Kamion(Integer.parseInt(tmp[1]),new Vozac(tmp[2],tmp[3]),Motor.valueOf(tmp[4]),tmp[5]));
				else if("Autobus".equals(tmp[0]))
					vozila.add(new Autobus(Integer.parseInt(tmp[1]),new Vozac(tmp[2],tmp[3]),Motor.valueOf(tmp[4]),tmp[5],Integer.parseInt(tmp[6])));
			}
			catch(IndexOutOfBoundsException|IllegalArgumentException e)
			{
				System.out.println("Pogresan format u liniji ulaznog fajla!!");
			}
		}
		return vozila;
	}
}