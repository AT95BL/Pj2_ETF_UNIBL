import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Collections;

public class VirtuelnaPosta{
	
	public static long startTime=0;
	public static long endTime=0;
	
	public static ArrayList<Razglednica> generisiRazglednice()
	{
		ArrayList<Razglednica> list=new ArrayList<>();
		for(int i=1;i<=15;i++)
			list.add(new Razglednica("Posiljalac"+i,"Primalac"+i,"Sadrzaj","Slika"+i+".png"));
		return list;
	}
	
	public static ArrayList<Pismo> generisiPisma()
	{
		ArrayList<Pismo> list=new ArrayList<>();
		for(int i=1;i<=15;i++)
			list.add(new Pismo("Posiljalac"+i,"Primalac"+i,"Sadrzaj.txt"));
		return list;
	}
	
	public static ArrayList<VrijednosnaPosiljka> generisiVrijednosnePosiljke()
	{
		ArrayList<VrijednosnaPosiljka> list=new ArrayList<>();
		Valuta[]valute=Valuta.values();
		Random random=new Random();
		for(int i=1;i<=15;i++)
		{
			list.add(new VrijednosnaPosiljka("Posiljalac"+i,"Primalac"+i,random.nextInt(1000),valute[random.nextInt(3)]));
		}
		return list;
	}
	
	public static void main(String[] args){
		
		startTime=new Date().getTime();
		
		ArrayList<Posiljka> posiljke=new ArrayList<>();
		posiljke.addAll(generisiPisma()); 
		posiljke.addAll(generisiRazglednice()); 
		posiljke.addAll(generisiVrijednosnePosiljke());
		
		Collections.shuffle(posiljke);
		
		RazvrstavanjeNit razvrstavanjeNit = new RazvrstavanjeNit(posiljke);
		razvrstavanjeNit.start();
		try{
			razvrstavanjeNit.join();
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		System.out.println("Vrijeme trajanja simulacije: " + (endTime-startTime));
		var files=RazvrstavanjeNit.SERIALIZATION_FOLDER.listFiles();
		for(var file:files)
		{
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+"[B]");
		}	
	}
}