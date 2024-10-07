
import java.nio.file.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public abstract class Parser<T>
{
	protected Path path;
	public Parser(Path path)
	{
		this.path=path;
	}
	
	public abstract ArrayList<T> importFile()throws IOException;
	
	protected List<String> getLines()throws IOException
	{
		return Files.readAllLines(this.path);
	}
	
	protected  String[] getLineContent(String line,String delimiter)
	{
		return line.split(delimiter);
	}
}