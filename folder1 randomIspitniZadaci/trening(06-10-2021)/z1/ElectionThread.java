
import java.util.*;

public class ElectionThread extends Thread{
	ArrayList<Student> studentiZaIzbor=new ArrayList<>();
	HashSet<Student> rezultatiIzbora=new HashSet<>();

	// Constructor
	public ElectionThread(ArrayList<Student> studentiZaIzbor){
		this.studentiZaIzbor=studentiZaIzbor;
	}

	@Override
	public void run(){
		Random random=new Random();

		for(var student:studentiZaIzbor){
			System.out.println(student + " trenutno glasa na izborima..");

			while(true){
				int kandidat=random.nextInt(studentiZaIzbor.size());
				Student tmp=this.studentiZaIzbor.get(kandidat);
				if(tmp.equals(student)){
					continue;
				}
				rezultatiIzbora.add(tmp);
				break;
			}
		}
	}
}