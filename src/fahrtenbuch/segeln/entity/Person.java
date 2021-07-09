package fahrtenbuch.segeln.entity;

import java.util.Date;

public class Person {

	private String Name;
	private String Mail;
	private Date geburstag;
	
	
	
	public Person(String name, String mail) {
		super();
		Name = name;
		Mail = mail;
		
		
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public Date getGeburstag() {
		return geburstag;
	}
	public void setGeburstag(Date geburstag) {
		this.geburstag = geburstag;
	}
	
	
}
