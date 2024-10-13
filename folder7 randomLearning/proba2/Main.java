
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Main{
	public static void main(String[] args){

		PrintWriter printWriter=null;

		try{
			printWriter=new PrintWriter(new BufferedWriter(new FileWriter("datoteka.txt")));
			printWriter.println("Ovo je prva rečenica!");
			printWriter.println("Ovo je druga rečenica!");

		}catch(IOException ex){
			System.err.println(ex);

		}finally{
			if(printWriter != null){
				printWriter.close();
			}
		}

		// Čitanje iz datoteke
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader("datoteka.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Ispisuje svaku liniju u konzolu
            }
        } catch(IOException ex){
            System.err.println(ex);
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }

        // Čitanje iz datoteke
        List<String> linije=null;
        
        try{
        	Path path=Paths.get("datoteka.txt");
        	linije=Files.readAllLines(path);
        }catch(IOException ex){
        	ex.printStackTrace();
        }

        for(var linija:linije){
        	System.out.println(linijan);
        }
	}
}