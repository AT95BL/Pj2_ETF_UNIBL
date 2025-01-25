
public class VrijednosnaPosiljka extends Posiljka{
	Valuta valuta;
	
	// Constructor
	public VrijednosnaPosiljka(){
		super();
	}
	
	// Constructor
	public VrijednosnaPosiljka(String adresaPosiljaoca, String adresaPrimaoca, int tezina){
		super(adresaPosiljaoca, adresaPrimaoca, tezina);
	}
	
	// Constructor
	public VrijednosnaPosiljka(String adresaPosiljaoca, String adresaPrimaoca, int tezina, Valuta valuta){
		super(adresaPosiljaoca, adresaPrimaoca, tezina);
		this.valuta=valuta;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\n"
		+ this.valuta.toString();
	}
}