
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.HashMap;

public class Finder implements FileVisitor<Path>
{
	private Path root;
	private String rijec;
	private String ekstenzija;
	public HashMap<Path,Integer> map=new HashMap<>();
	
	public Finder(Path path,String rijec,String ekstenzija)
	{
		this.root=path;
		this.rijec=rijec;
		this.ekstenzija=ekstenzija;
	}
	
	private void find(Path path)
	{
		String fileName=path.getFileName().toString();
		if(fileName.endsWith(ekstenzija))
		{
			try
			{
				var lines=Files.readAllLines(path);
				for(var line:lines)
				{
					var tmp=line.split("\\W+");
					for(var word:tmp)
						if(this.rijec.equalsIgnoreCase(word))
						{
							if(this.map.containsKey(path))
								this.map.put(path,this.map.get(path)+1);
							else
								this.map.put(path,1);
						}
					
				}
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir,BasicFileAttributes attrs)throws IOException
	{
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)throws IOException
	{
		find(file);
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file,IOException exc)throws IOException
	{
		System.err.println("Greska prilikom otvaranja direktorijuma..")
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitDirectory(Path dir,IOException exc) throws IOException
	{
		return FileVisitResult.CONTINUE;
	}
}