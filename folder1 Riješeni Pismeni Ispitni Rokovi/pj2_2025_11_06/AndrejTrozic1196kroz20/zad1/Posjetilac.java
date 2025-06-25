
public class Posjetilac{
	public static int ID=1;
	int id;
	
	public Posjetilac(){
		this.id = ID++;
	}
	
	@Override
	public String toString(){
		return "Posjetilac" + this.id;
	}
}