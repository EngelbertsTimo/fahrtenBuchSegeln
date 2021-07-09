package fahrtenbuch.segeln;

import java.sql.SQLException;
import java.util.List;

import fahrtenbuch.Mail.MailTest;
import fahrtenbuch.data.database_Conection;
import fahrtenbuch.segeln.entity.Boot;
import fahrtenbuch.segeln.entity.Fahrt;
import fahrtenbuch.segeln.entity.Person;
import fahrtenbuch.segeln.factory.reader.BootReader;

public class Main {

	public static void main(String[] args) {

		Person p1 = new Person("test 1", "timoengelberts@googlemail.com");

		List<Boot> alleBoote = new BootReader().getAlleBoote();
		Boot a = alleBoote.get(0);

		System.out.println(a.getType().getName() + " ; " +a.getName());
		
		if (a.getNutzerList() == null) {
			System.out.println(a.getType().getPlätze());
		}
		
		database_Conection connection = database_Conection.getInstance();
		connection.createNewDatabase("test.db");
		try {
			connection.initialise();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

		MailTest mail = MailTest.getInstance();
		/*mail.sendMail("test Betreff","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff1","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff2","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff3","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff4","Test Body","timoengelberts@googlemail.com");*/
		
		new Fahrt().startFahrt();
	}

}
