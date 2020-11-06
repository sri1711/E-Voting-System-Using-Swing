//package evote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class Sri {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * 
     */
    public void insert(String Name,String Dob,String MailId,String PhoneNumber,String AadharNumber,String VoterId) {
        String sql = "INSERT INTO VoterRegistration(Name,Dob,MailId,PhoneNumber,AadharNumber,VoterId) VALUES(?,?,?,?,?,?)";


        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Name);
            pstmt.setString(2, Dob);
            pstmt.setString(3, MailId);
            pstmt.setString(4, PhoneNumber);
            pstmt.setString(5, AadharNumber);
            pstmt.setString(6, VoterId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sri app = new Sri();
        // insert three new rows
       app.insert("Surya.V","26.01.2002","suryaedu71@gmail.com","8072225533","xxxx xxx xxx","190701223");
    }

}



//app.insert("Surya.V","26.01.2002","suryaedu71@gmail.com","8072225533","xxxx xxx xxx","190701223");