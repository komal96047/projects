package BankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {
	 Connection con;
	    PreparedStatement ps;

	    public Conn() {
	        try {
	        	  Class.forName("org.postgresql.Driver");
	              con = DriverManager.getConnection(
	                  "jdbc:postgresql://localhost:5432/bank_management_system","postgres","tiger");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
