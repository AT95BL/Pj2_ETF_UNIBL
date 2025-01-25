import java.util.Random;

public class Razglednica extends Posiljka{
	
	String sadrzaj;
	String vizuelniDio; 												// .jpg .jepg .png
	
	Random random = new Random();
	
	public Razglednica(){ super();}
	
	public Razglednica(String adresaPrimaoca, String adresaPosiljaoca, int tezina, String sadrzaj, String vizuelniDio)throws IllegalArgumentException{
		
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
		
		if(!vizuelniDio.endsWith(".jpg")&&!vizuelniDio.endsWith(".jpeg")&&!vizuelniDio.endsWith(".png"))
			throw new IllegalArgumentException("Fotografija treba da ima ekstenziju .jpg ili .jpeg ili .png");
		
		this.sadrzaj = sadrzaj;
		this.vizuelniDio = vizuelniDio;
	}
	
	public Razglednica(String adresaPrimaoca, String adresaPosiljaoca, String sadrzaj, String vizuelniDio)throws IllegalArgumentException{
		
		super(adresaPrimaoca, adresaPosiljaoca);
		if(!vizuelniDio.endsWith(".jpg")&&!vizuelniDio.endsWith(".jpeg")&&!vizuelniDio.endsWith(".png"))
			throw new IllegalArgumentException("Fotografija treba da ima ekstenziju .jpg ili .jpeg ili .png");
		this.sadrzaj = sadrzaj;
		this.vizuelniDio = vizuelniDio;
		this.tezina=random.nextInt(10)+1;
		
	}
	
	@Override
	public String toString(){
		
		return super.toString() 
		+ "Sadrzaj: " + this.sadrzaj + "\n"
		+ "Vizuelni dio: " + this.vizuelniDio;
	}
}
