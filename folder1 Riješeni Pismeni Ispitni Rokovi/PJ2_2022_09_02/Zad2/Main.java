
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.function.Function;

public class Main
{
	public static ArrayList<Film> generateFilmovi()
	{
		Random random=new Random();
		ArrayList<Film> filmovi=new ArrayList<>();
		for(int i=1;i<=40;i++)
			filmovi.add(new Film("Film"+i,2022-(random.nextInt(40)),random.nextInt(50)*1000000,random.nextDouble()*9.0+1));
		return filmovi;
	}
	
	public static void main(String[]args)
	{
		var list=generateFilmovi();
		System.out.println("Filmovi prema godinama:");
		list.stream().collect(Collectors.groupingBy(Film::getGodinaObjavljivanja)).entrySet().stream().forEach((s)->{
			System.out.println("Godina:"+s.getKey());
			s.getValue().forEach(System.out::println);
		});
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Unesite ocjenu za filtriranje:");
		double ocjena=scanner.nextDouble();
		System.out.println("Filmovi sa ocjenom vecom od "+ocjena);
		list.stream().filter((s)->s.ocjena>ocjena).forEach(System.out::println);
		
		System.out.println("Filmovi ciji je budzet veci od 10M:");
		list.stream().filter((s)->s.budzet>10_000_000).forEach(System.out::println);
		
		System.out.println("Filmovi koji su izdati u prvoj deceniji 2000-ih");
		list.stream().filter((s)->s.godinaObjavljivanja>=2000 && s.godinaObjavljivanja<2010).forEach(System.out::println);
		
		Function<Film,String> func=(s)->{
			if(s.ocjena>=1&& s.ocjena <= 6.99)
				return "1.0-6.99";
			else if(s.ocjena>=7.0 && s.ocjena<=7.99)
				return "7.0-7.99";
			else if(s.ocjena>=8.0 && s.ocjena<=8.99)
				return "8.0-8.99";
			else //if(s.ocjena>=9.0 && s.ocjena<=10.0)
				return "9.0-10.0";	
		};
		
		list.stream().collect(Collectors.groupingBy(func)).entrySet().forEach((s)->{
			System.out.println(s.getKey());
			s.getValue().forEach(System.out::println);
		});
		
		System.out.print("Prosjecna ocjena filmova 90-ih:");
		var rez=list.stream().filter((s)->s.godinaObjavljivanja>=1990 && s.godinaObjavljivanja<2000).mapToDouble(Film::getOcjena).average();
		System.out.println(rez.getAsDouble());
		
		System.out.print("Ukupni budzet filmova 80-ih:");
		var rez1=list.stream().filter((s)->s.godinaObjavljivanja>=1980 && s.godinaObjavljivanja<1990).mapToInt(Film::getBudzet).sum();
		System.out.println(rez1);
	}
}