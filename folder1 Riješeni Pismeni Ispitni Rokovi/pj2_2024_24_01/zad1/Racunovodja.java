
public class Racunovodja extends Zaposleni{
	
	int redniBrojPoruke=0;
	
	// Constructor
	public Racunovodja(){
		super();
	}
	
	@Override
	public void generisiZadatak(){
		this.listaUradjenihZadataka.add( new Zadatak("Obracun troskova # " + this.id));
		this.brojZadatakaUListi++;
		this.redniBrojPoruke++;
	}
	
	@Override
	public void run(){
		
		while(Main.trajanjeSimulacije){
			
			System.out.println(this);
		
			try{
				Thread.sleep(10000);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			this.generisiZadatak();
			
			this.pauza();
		}
	}
	
	public double izracunajDnevnicu(Zaposleni zaposleni){
		
		if(zaposleni.brojZadatakaUListi >= 10){
			return zaposleni.cijenaRada + zaposleni.godineRadaUKompaniji;
		}
		
		return 25;
	}
}