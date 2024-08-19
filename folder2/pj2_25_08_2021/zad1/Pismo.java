import java.util.Random;

public class Pismo extends Posiljka{
	
	String sadrzaj;
	
	Random random = new Random();
	
	public Pismo(){ super();}
	
	public Pismo(String adresaPrimaoca, String adresaPosiljaoca, int tezina, String sadrzaj)throws IllegalArgumentException{
		
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
		if(!sadrzaj.endsWith(".txt"))
			throw new IllegalArgumentException("Pismo mora imati ekstenziju .txt");
		this.sadrzaj = sadrzaj;
	}
	
	public Pismo(String adresaPrimaoca, String adresaPosiljaoca, String sadrzaj)throws IllegalArgumentException{
		
		super(adresaPrimaoca, adresaPosiljaoca);
		if(!sadrzaj.endsWith(".txt"))
			throw new IllegalArgumentException("Pismo mora imati ekstenziju .txt");
		this.sadrzaj = sadrzaj;
		this.tezina = random.nextInt(20)+1;
	}
	
	@Override
	public String toString(){
		
		return super.toString() 
		+ "Sadrzaj: " + this.sadrzaj;
	}
}