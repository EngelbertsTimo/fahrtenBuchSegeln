package fahrtenbuch.data;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class database_Conection {
	
 private static database_Conection instance;
	 
	 private database_Conection(){}
	    
	    public static database_Conection getInstance(){
	        if(instance == null){
	            instance = new database_Conection();
	        }
	        return instance;
	    }
	    
	
	  public void createNewDatabase(String fileName) {
			String loca = System.getProperty("user.dir")+"\\database";
			
	        String url = "jdbc:sqlite:"+loca+"\\" + fileName;

	        try (Connection conn = DriverManager.getConnection(url)) {
	            if (conn != null) {
	                DatabaseMetaData meta = conn.getMetaData();
	                System.out.println("The driver name is " + meta.getDriverName());
	                System.out.println("A new database has been created.");
	            }

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}
