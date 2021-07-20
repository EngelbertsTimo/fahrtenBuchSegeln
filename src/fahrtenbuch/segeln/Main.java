package fahrtenbuch.segeln;

import java.sql.SQLException;
import java.util.List;

import fahrtenbuch.Mail.MailTest;
import fahrtenbuch.data.database_Conection;
import fahrtenbuch.segeln.entity.Boot;
import fahrtenbuch.segeln.entity.Fahrt;
import fahrtenbuch.segeln.entity.Person;
import fahrtenbuch.segeln.factory.reader.BootReader;
import fahrtenbuch.gui.Gui;

public class Main {

	public static void main(String[] args) {
//dfdsf
		/*Person p1 = new Person("test 1", "timoengelberts@googlemail.com");

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
		mail.sendMail("test Betreff","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff1","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff2","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff3","Test Body","timoengelberts@googlemail.com");
		mail.sendMail("test Betreff4","Test Body","timoengelberts@googlemail.com");*/
		Gui gui = new Gui();

		gui.setVisible(true);
		gui.addStart();
		
		
		RunnableDemo R1 = new RunnableDemo( "Thread-1");
	      R1.start();
	      
	      RunnableDemo R2 = new RunnableDemo( "Thread-2");
	      R2.start();
	      
	      
	      RunnableDemo R3 = new RunnableDemo( "Thread-3");
	      R3.start();
	      
	      
	      RunnableDemo R4 = new RunnableDemo( "Thread-4");
	      R4.start();
	      
	      
	      RunnableDemo R5 = new RunnableDemo( "Thread-5");
	      R5.start();
		
	      for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}

}

class RunnableDemo implements Runnable {
	   private Thread t;
	   private String threadName;
	   
	   RunnableDemo( String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );

			MailTest mail = MailTest.getInstance();
			//mail.sendMail(threadName+"Betreff","Test Body" + threadName,"timoengelberts@googlemail.com");
	    /*  try {
	         for(int i = 40; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
	         }
	      } catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }*/
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}