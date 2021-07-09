package fahrtenbuch.segeln.factory.reader;

import java.util.ArrayList;
import java.util.List;

import fahrtenbuch.segeln.entity.Boot;
import fahrtenbuch.segeln.entity.BootsType;

public class BootReader {

	BootsType mobo = new BootsType("mobo", 1);
	private List<Boot> alleBoote = new ArrayList<Boot>();
	
	public List<Boot> getAlleBoote() {
	
		alleBoote.add(new Boot ("a",mobo));
		
		return alleBoote;
	}

}
