
import java.io.Serializable;

public class User implements Serializable{
	String name;
	String password;

	public User(){
		name="AndrejTrozic";
		password="TheQuiterYouBecame,theMoreYouAreAbleToHear..";
	}

	public User(String name, String password){
		this.name=name;
		this.password=password;
	}

	@Override
	public String toString(){
		return this.name + " " + this.password;
	}
}