package fahrtenbuch.segeln.entity;

public class BootsType {

	private String name;
	private int sitzpl�tze; 
	
	
	public BootsType(String nameInput, int personenanzahlInput ) {
		this.name = nameInput;
		this.sitzpl�tze = personenanzahlInput;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPl�tze() {
		return sitzpl�tze;
	}
}
