import java.util.Random;

public class VrijednosnaPosiljka extends Posiljka{
	
	Valuta valuta;
	
	Random random = new Random();
	
	public VrijednosnaPosiljka(){ super();}
	
	public VrijednosnaPosiljka(String adresaPrimaoca, String adresaPosiljaoca, int tezina, Valuta valuta){
		
		super(adresaPrimaoca, adresaPosiljaoca, tezina);
		this.valuta = valuta;
	}
	
	public VrijednosnaPosiljka(String adresaPrimaoca, String adresaPosiljaoca,  Valuta valuta){
		
		super(adresaPrimaoca, adresaPosiljaoca);
		this.valuta = valuta;
		this.tezina = random.nextInt(100)+1;
	}
	
	@Override
	public String toString(){
		
		return super.toString() 
		+ "Valuta: " + this.valuta.toString();
	}
}