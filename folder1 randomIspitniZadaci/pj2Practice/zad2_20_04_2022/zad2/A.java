
public class A implements MyInterface{
	Double value;
	String name;
	Status status;
	
	// Constructor
	public A(){}
	
	public A(Double value, String name, Status status){
		this.value = value;
		this.name = name;
		this.status = status;
	}
	
	@Override
	public Double getValue(){
		return this.value;
	}
	
	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public Status getStatus(){
		return this.status;
	}
	
	@Override
	public String toString(){
		return "Class A " + "\n" +
			"Value: " + this.value + "\n" +
			"Name: " + this.name + "\n" +
			"Status: " + this.status.toString();
	}
}