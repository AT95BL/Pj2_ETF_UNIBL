
public abstract class Korisnik extends Thread{
	public static int globalID;
	int id;
	
	String ime;
	String prezime;
	
	boolean bazen, sauna, masaza;
	
	// Constructor
	public Korisnik(){
		this.id = ++globalID;
		this.ime =  "ime"+id;
		this.prezime = "prezime"+id;
		this.bazen = this.sauna = this.masaza = false;
	}
	
	@Override
	public String toString(){
		return "Korisnik: " + this.ime + " " + this.prezime;
	}
	
	@Override
	public void run(){
		
		if(bazen){
			synchronized(Simulacija.BAZEN){
				System.out.println(this + " je na bazenu..");
				try{
					Thread.sleep(2000);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
		}
		else if(sauna){
			synchronized(Simulacija.SAUNA){
				System.out.println(this + " je tu po nekim saunama..");
				try{
					Thread.sleep(5000);
				}catch(InterruptedException ex){
					ex.printStackTrace();
					}
			}
		}
		else if(masaza){
			synchronized(Simulacija.MASAZA){
				System.out.println(this + " je na masazi nekoj..");
				try{
					Thread.sleep(3000);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
		}
		return;
	}
}