
public class FirmaKorisnik extends Korisnik{
	
	String firmaPodaci="";
	
	public FirmaKorisnik(){
		super();
		this.firmaPodaci = this.firmaPodaci + "Firma u kojoj radi: " + this.toString();
	}
}