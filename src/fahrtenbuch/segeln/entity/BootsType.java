package fahrtenbuch.segeln.entity;

public class BootsType {

	private String name;
	private int sitzplätze; 
	
	
	public BootsType(String nameInput, int personenanzahlInput ) {
		this.name = nameInput;
		this.sitzplätze = personenanzahlInput;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPlätze() {
		return sitzplätze;
	}
}
