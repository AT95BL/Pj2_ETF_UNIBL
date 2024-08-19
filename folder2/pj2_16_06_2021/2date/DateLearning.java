import java.util.Date;

public class DateLearning{
	
	public static final int WORKING=1000;
	
	public long startTime;
	public long endTime;
	
	public DateLearning(){
		
		this.startTime = new Date().getTime();
		
		try{
			Thread.sleep(WORKING);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		
		this.endTime = new Date().getTime();
	}
	
	@Override
	public String toString(){
		
		return "Start time: " + this.startTime + "\n"
			+ "End time: " + this.endTime + "\n";
	}
	
	public static void main(String[] args){
		
		DateLearning dl = new DateLearning();
		System.out.println(dl);
	}
}