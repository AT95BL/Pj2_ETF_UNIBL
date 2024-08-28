
import java.util.List;
import java.util.LinkedList;

public class Proba1{
	
	public static void main(String[] args){
		List list = new LinkedList();			//	<=> List<Object> list = new LinkedList();
		list.add(new Integer(1));			//	<=> tipa sa Object o = new Integer(1);
		Integer i = list.iterator().next();		//	<=> Integer i = ko Zna Šta!?
												//		Integer i = (Integer)list.iterator().next(); resolves compiler warning	
		System.out.println(i);
	}
}

/*
	Zbog čega nastaje kompajlerska greška?
	Kako dolazi do kompajlerske greške?
	Šta sugeriše kompajlerska greška?
	Kako prepraviti code?

*/