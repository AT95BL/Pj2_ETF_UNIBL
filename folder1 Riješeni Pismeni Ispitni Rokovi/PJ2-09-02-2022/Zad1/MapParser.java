
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class MapParser extends Parser<String>
{
	public MapParser(Path path)
	{
		super(path);
	}
	
	@Override
	public ArrayList<String> importFile()throws IOException
	{
		ArrayList<String> list=new ArrayList<>();
		var lines=this.getLines();
		var tmp=this.getLineContent(lines.get(0),"-");
		list.addAll(Arrays.asList(tmp));
		return list;
	}
}