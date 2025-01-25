
public class Pismo extends Posiljka{
	String sadrzaj;
	
	// Constructor
	public Pismo(){
		super();
	}
	
	// Constructor
	public Pismo(String adresaPrimaoca, String adresaPosiljaoca, int tezina){
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
	}
	
	// Constructor
	public Pismo(String adresaPrimaoca, String adresaPosiljaoca, int tezina, String sadrzaj){
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
		this.sadrzaj=sadrzaj;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\n"
		+ this.sadrzaj;
	}
}