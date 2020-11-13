package eVoting;
import com.email.durgesh.*;
import java.sql.*;

public class mail {
	public static void main(String args[]) {
		publishResults("voter_registration.db","voterRegistration");
		publishResults("CandidateDatabase.db","candidateDatabase");
	}
	
	public static void publishResults(String database,String table) {
		 Connection con =null;
	        try{
	        String url = "jdbc:sqlite:D:/Java/mini_project/Surya/data/" + database;
	        //https://github.com/sri1711/Java_mini_project_sem_3/blob/master/Completed_Registration/CandidateDatabase.db
	         con = DriverManager.getConnection(url);
	         System.out.println("Connection Built successfully");
	         Statement stmt = con.createStatement();
	         String sql = "SELECT MailId FROM " + table;
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	        	 System.out.println(rs.getString("MailId"));
	     		try {
	    			Email email = new Email("ECIjavaproject@gmail.com","java*demo");
	    			email.setSubject("Result of the election...");
	    			email.setFrom("ECIjavaproject@gmail.com", "Election Commision Of India");
	    			email.addRecipient(rs.getString("MailId"));
	    			email.setContent("<h1>{Party Name}'s {CandidateName}</h1>"

	    					+ "<h3>had been selected by the people with the majority of {votesObtained} votes.</h3>", "text/html");
	    			email.send();
	    		}
	    		catch(Exception e) {
	    			System.out.println(e.getLocalizedMessage());
	    		}
	         }
	        }
	        catch(SQLException sqlE) {
	        	System.out.println(sqlE);
	        }
	        try {
	        	System.out.println("closing the connection now");
	        	con.close();
	        }
	        catch(Exception e) {
	        	System.out.println("Can't close the connection!");
	        }
	}

}
