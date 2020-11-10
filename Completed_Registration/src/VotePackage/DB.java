package VotePackage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {
	// static Connection conn =null;
		// static String url = "jdbc:sqlite:data/voter_registration.db";
		public static void insert(String Name,String Dob,String MailId,String PhoneNumber,String AadharNumber,String VoterId){
			Connection conn =null;
			try{
			//String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
			String url = "jdbc:sqlite:voter_registration.db";
	         conn = DriverManager.getConnection(url);
	         System.out.println("Connection Built successfully");
	         System.out.println("Inside Insertion");

	        String sql = "INSERT INTO VoterRegistration(Name,Dob,MailId,PhoneNumber,AadharNumber,VoterId) VALUES(?,?,?,?,?,?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);            
	            pstmt.setString(1, Name);
	            pstmt.setString(2, Dob);
	            pstmt.setString(3, MailId);
	            pstmt.setString(4, PhoneNumber);
	            pstmt.setString(5, AadharNumber);
	            pstmt.setString(6, VoterId);
	            pstmt.executeUpdate();
	            System.out.println("Finished Insertion");
	        } catch (SQLException e){
	          	System.out.println(e.getMessage());
	          	System.out.println("error @Insertion");
	        }
	        try{
	        	conn.close();
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        }
		}

		public static Boolean checkExistance(String AadharNumber){
				Connection conn =null;
			 	//String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
				String url = "jdbc:sqlite:voter_registration.db";
			 try{
			 	conn = DriverManager.getConnection(url);
	         	System.out.println("Connection Built successfully");
	        	Statement stmt = conn.createStatement();
	        	String sql = "SELECT * FROM VoterRegistration WHERE AadharNumber = "+AadharNumber;
	        	ResultSet rs = stmt.executeQuery(sql);
	        	rs.getString("Name");
	         	System.out.println("Person already registared as:-");
	         	System.out.println(rs.getString("Name"));
	         	System.out.println(rs.getString("Dob"));
	         	System.out.println(rs.getString("MailId"));
	         	System.out.println(rs.getString("PhoneNumber"));
	         	System.out.println(rs.getString("VoterId"));
				try{
	        		conn.close();
	        	}
	        	catch(Exception e1){
	        		System.out.println(e1);
	        	}         	
	         	return true;
			 }catch(SQLException e2){
			 	System.out.println(e2.getMessage());
			 	try{
	        		conn.close();
	        	}
	        	catch(Exception e3){
	        		System.out.println(e3);
	        	}   
			 	return false;
			 	
			 }

		}
		
		public static void Candidate_database(String CandidateId, String Candidate_name,String Party_name,File Candidate_image,File Party_logo,String Party_email){
			Connection conn = null;
			ByteArrayOutputStream bos1 = null;
			ByteArrayOutputStream bos2 = null;
			try{
				
				//Url of DataBase
				String url = "jdbc:sqlite:CandidateDatabase.db";
				
				//Connecting Database 
				conn = DriverManager.getConnection(url);
				System.out.println("\n Connected");
				
				//Sql Query to execute
				String sqlquery = "INSERT INTO CandidateDatabase(CandidateId,CandidateName,PartyName,PartyLogo,CandidateImage,PartyEmail) VALUES(?,?,?,?,?,?)";
				
				
				PreparedStatement ps = conn.prepareStatement(sqlquery);
				try
				{
					InputStream fis1 = new FileInputStream(Candidate_image);
					byte[] buffer1 = new byte[1024];
					bos1 = new ByteArrayOutputStream();
					for (int len; (len = fis1.read(buffer1)) != -1;) {
						bos1.write(buffer1, 0, len);
					}
					
					InputStream fis2 = new FileInputStream(Party_logo);
					byte[] buffer2 = new byte[1024];
					bos2 = new ByteArrayOutputStream();
					for (int len; (len = fis2.read(buffer2)) != -1;) {
						bos2.write(buffer2, 0, len);
					}

				
					ps.setString(1,CandidateId);
					ps.setString(2,Candidate_name);
					ps.setString(3,Party_name);
					ps.setBytes(5,bos1.toByteArray());
					ps.setBytes(4,bos2.toByteArray());
					ps.setString(6,Party_email);
					
					
					
					
//					String selectSQL = "SELECT picture FROM materials WHERE id=?";
//			        ResultSet rs = null;
//			        FileOutputStream fos = null;
//			        ps.
//					
//					
//					JOptionPane.showMessageDialog(null, );
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				// Executing Sql Query
				ps.executeUpdate();
				System.out.println("Added");
				JOptionPane.showMessageDialog(null, "Registered Successfully");
				
						
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			finally{
				try{
					conn.close();
				}
				catch(SQLException se){
					System.out.println(se.getMessage());
				}
				
			}
			
		}

}
