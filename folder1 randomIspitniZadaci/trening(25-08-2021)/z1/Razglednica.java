
public class Razglednica extends Posiljka{
	String sadrzaj;
	String vizuelniDio;
	
	// Constructor
	public Razglednica(){
		super();
	}
	
	// Constructor
	public Razglednica(String adresaPrimaoca, String adresaPosiljaoca, int tezina){
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
	}
	
	// Constructor 
	// može da baca Exception!!
	public Razglednica(String adresaPrimaoca, String adresaPosiljaoca, int tezina, String sadrzaj, String vizuelniDio)throws IllegalArgumentException{
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
		this.sadrzaj=sadrzaj;
		
		if(!vizuelniDio.endsWith(".jpg") && !vizuelniDio.endsWith(".jpeg") && !vizuelniDio.endsWith(".png")){
			throw new IllegalArgumentException("Fotografija mora biti datoteka sa nekom od ekstenzija: .jpg, .jpeg ili .png ..");
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + "\n"
		+ this.sadrzaj + "\n"
		+ this.vizuelniDio;
	}
}