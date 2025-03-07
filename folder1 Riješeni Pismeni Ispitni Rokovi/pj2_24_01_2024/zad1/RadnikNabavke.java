
public class RadnikNabavke extends Zaposleni{
	
	int redniBrojPoruke=0;
	
	// Constructor
	public RadnikNabavke(){
		super();
	}
	
	@Override
	public void generisiZadatak(){
		this.listaUradjenihZadataka.add( new Zadatak("Upit za nabavku # " + this.id));
		this.brojZadatakaUListi++;
		this.redniBrojPoruke++;
	}
	
	@Override
	public void run(){
		
		while(Main.trajanjeSimulacije){
			
			System.out.println(this);
		
			try{
				Thread.sleep(3000);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			this.generisiZadatak();
			
			this.pauza();
		}
	}
}