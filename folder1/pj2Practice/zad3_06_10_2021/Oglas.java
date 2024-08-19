
import java.util.Date;

public class Oglas{
	String naziv;
	String kratakOpis;
	Date datumObjavljivanja;
	int vrijemeTrajanjaOglasa;
	int plata;
	int brojGodinaRadnogIskustva;
	String grad;
	KategorijaPosla kategorijaPosla;
	
	// Constructor
	public Oglas(){
		this.naziv="";
		this.kratakOpis="";
		this.datumObjavljivanja=null;
		this.vrijemeTrajanjaOglasa=
		this.plata=
		this.brojGodinaRadnogIskustva=0;
		this.kategorijaPosla=null;
	}
	
	// Constructor
	public Oglas(String naziv,
				String kratakOpis,
				Date datumObjavljivanja,
				int vrijemeTrajanjaOglasa,
				int plata,
				int brojGodinaRadnogIskustva,
				String grad,
				KategorijaPosla kategorijaPosla){
					this.naziv=naziv;
					this.datumObjavljivanja=datumObjavljivanja;
					this.vrijemeTrajanjaOglasa=vrijemeTrajanjaOglasa;
					this.plata=plata;
					this.brojGodinaRadnogIskustva=brojGodinaRadnogIskustva;
					this.grad=grad;
					this.kategorijaPosla=kategorijaPosla;
	}
	
	public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKratakOpis() {
        return kratakOpis;
    }

    public void setKratakOpis(String kratakOpis) {
        this.kratakOpis = kratakOpis;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public int getVrijemeTrajanjaOglasa() {
        return vrijemeTrajanjaOglasa;
    }

    public void setVrijemeTrajanjaOglasa(int vrijemeTrajanjaOglasa) {
        this.vrijemeTrajanjaOglasa = vrijemeTrajanjaOglasa;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBrojGodinaRadnogIskustva() {
        return brojGodinaRadnogIskustva;
    }

    public void setBrojGodinaRadnogIskustva(int brojGodinaRadnogIskustva) {
        this.brojGodinaRadnogIskustva = brojGodinaRadnogIskustva;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public KategorijaPosla getKategorijaPosla() {
        return kategorijaPosla;
    }

    public void setKategorijaPosla(KategorijaPosla kategorijaPosla) {
        this.kategorijaPosla = kategorijaPosla;
    }
	
	@Override
	public String toString(){
		return
				"Naziv Oglasa: " + this.naziv + "\n" +
				"Kratak Opis: " + this.kratakOpis + "\n" +
				"Datum Objavljivanja: " + this.datumObjavljivanja + "\n" +
				"Vrijeme Trajanja Oglasa: " + this.vrijemeTrajanjaOglasa + "\n" +
				"Plata: " + this.plata + "\n" +
				"Broj Godina Radnog Iskustva: " + this.brojGodinaRadnogIskustva + "\n" +
				"Grad: " + this.grad + "\n" +
				"Kategorija Posla: " + this.kategorijaPosla.toString();
	}
}