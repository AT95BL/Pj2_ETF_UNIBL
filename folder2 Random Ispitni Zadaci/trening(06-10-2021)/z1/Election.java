
import java.util.*;

public class Election{
	public static HashMap<Univerzitet, ArrayList<Student>> kandidatiKojiSuProsliFakultetske=new HashMap<>();
	public static ArrayList<Student> kandidatiKojiSuProsliUniverzitetske=new ArrayList<>();
	public static ArrayList<Student> pobjedniciNaDrzavnim=new ArrayList<>();

	public static boolean odrzani=false;

	public static void startElection(Drzava d){

		for(var univerzitet:d.univerziteti){
			ArrayList<ElectionThread> izbornaMjesta=new ArrayList<>();
			for(var fakultet:univerzitet.fakulteti){
				ElectionThread thread=new ElectionThread(fakultet.studentiFakulteta);
				izbornaMjesta.add(thread);
					thread.start();
				for(var izbornaMjestaThread:izbornaMjesta){
					try{
						izbornaMjestaThread.join();
					}catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
			}
			System.out.println("Zavrsena je prva faza izbora na univerzitetu: " + univerzitet.nazivUniverziteta);
			ArrayList<Student> pobjedniciFakultetskihIzbora=new ArrayList<>();
			for(var iM:izbornaMjesta){
				pobjedniciFakultetskihIzbora.addAll(iM.rezultatiIzbora);
			}
			kandidatiKojiSuProsliFakultetske.put(univerzitet, pobjedniciFakultetskihIzbora);
		}


		ArrayList<ElectionThread> izbornaMjesta=new ArrayList<>();
		for(var univerzitet:kandidatiKojiSuProsliFakultetske.entrySet()){
			ElectionThread thread=new ElectionThread(univerzitet.getValue());
			izbornaMjesta.add(thread);
				thread.start();
			for(var izbornaMjestaThread:izbornaMjesta){
				try{
					izbornaMjestaThread.join();
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
			System.out.println("Zavrsena druga faza izbornog procesa..");
			for(var iM:izbornaMjesta){
				kandidatiKojiSuProsliUniverzitetske.addAll(iM.rezultatiIzbora);
			}
		}

		ElectionThread thread=new ElectionThread(kandidatiKojiSuProsliUniverzitetske);
		thread.start();
		try{
			thread.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	} 
}