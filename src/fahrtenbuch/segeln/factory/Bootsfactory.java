package fahrtenbuch.segeln.factory;

import java.util.List;

import fahrtenbuch.segeln.entity.Boot;
import fahrtenbuch.segeln.factory.reader.BootReader;

public class Bootsfactory {

	private List<Boot> alleBoote;
	private BootReader bootReader = new BootReader();
	public Bootsfactory() {
		alleBoote=bootReader.getAlleBoote();
		
	};
}
