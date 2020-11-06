import java.sql.*;

public class DB{

	// public static void dataBase(String Name,String Dob,String MailId,String PhoneNumber,String AadharNumber,String VoterId){
	// 	Connection conn =null;
	// 	try{
	// 	String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
 //         conn = DriverManager.getConnection(url);
 //         System.out.println("Connection Built successfully");


 //        String sql = "INSERT INTO VoterRegistration(Name,Dob,MailId,PhoneNumber,AadharNumber,VoterId) VALUES(?,?,?,?,?,?)";
 //            PreparedStatement pstmt = conn.prepareStatement(sql);            
 //            pstmt.setString(1, Name);
 //            pstmt.setString(2, Dob);
 //            pstmt.setString(3, MailId);
 //            pstmt.setString(4, PhoneNumber);
 //            pstmt.setString(5, AadharNumber);
 //            pstmt.setString(6, VoterId);
 //            pstmt.executeUpdate();
 //        } catch (SQLException e){
 //            System.out.println(e.getMessage());
 //        }
	// }

	public static void check(String AadharNumber){
		Connection con =null;
		try{
		String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
         con = DriverManager.getConnection(url);
         System.out.println("Connection Built successfully");

         Statement stmt = con.createStatement();
        String sql = "SELECT * FROM VoterRegistration WHERE AadharNumber = "+AadharNumber;
            // PreparedStatement pstmt = conn.prepareStatement(sql);            
            // pstmt.setString(1, Name);
            // pstmt.setString(2, Dob);
            // pstmt.setString(3, MailId);
            // pstmt.setString(4, PhoneNumber);
            // pstmt.setString(5, AadharNumber);
            // pstmt.setString(6, VoterId);
            // pstmt.executeUpdate();
        	ResultSet rs = stmt.executeQuery(sql);
         	System.out.println("Results:-");
         	System.out.println(rs.getString("Name"));
         	System.out.println(rs.getString("Dob"));
         	System.out.println(rs.getString("MailId"));
         	System.out.println(rs.getString("PhoneNumber"));
         	System.out.println(rs.getString("VoterId"));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
	}
	public static void main(String[] args) {
		check("190701223");
	}

}