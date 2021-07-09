package fahrtenbuch.segeln.entity;

import java.util.List;

public class Boot {

	private String name;
	private BootsType type;
	private List<Person> nutzer = null;
	private Person pate=null;

	public String getName() {
		return name;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public BootsType getType() {
		return type;
	}

	public void changeType(BootsType type) {
		this.type = type;
	}
	
	public Boot(String nameInput, BootsType typeInput) {
		this.name=nameInput;
		this.type = typeInput;
	}
	
	public void addNutzer(Person input) {
		nutzer.add(input);
	}
	
	public List<Person> getNutzerList(){
		return nutzer;
	}
	
	
}


