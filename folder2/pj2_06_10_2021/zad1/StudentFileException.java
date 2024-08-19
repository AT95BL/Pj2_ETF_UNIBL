public class StudentFileException extends Exception{
	
	public StudentFileException(){
		super("Fajl sa studentima fakulteta nije u dobrom formatu");
	}
	
	public StudentFileException(String message){
		super(message);
	}
}
