package VotePackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestFrame {
	
	public static void display_image(String Candidate_name){
		JFrame frame = new JFrame();
		Connection conn = null;
		try{
			
			//Url of DataBase
			String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
			
			
			//Connecting Database 
			conn = DriverManager.getConnection(url);
			System.out.println("\n Connected");
			
			
			//Sql Query to execute
			String sqlquery = "SELECT * FROM CandidateDatabase WHERE PartyName=?";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sqlquery);
			ps.setString(1,Candidate_name);
			rs = ps.executeQuery();
			try{
			
				BufferedImage image = null;
				
				while(rs.next()){
					InputStream input = new BufferedInputStream( rs.getBinaryStream("PartyLogo"));
					//byte[] buffer = new byte[1024];
					
						image = ImageIO.read(input);
						ImageIcon background_icon = new ImageIcon(image);
						Image im = background_icon.getImage();
						Image resizedImage = im.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
						JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
						frame.add(Party_photo);
						Party_photo.setBounds(100,100,500,400);
						frame.setBackground(new Color(255,255,255));
					
            		
				}
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}
				
//			String selectSQL = "SELECT picture FROM materials WHERE id=?";
		    
				
				
				//JOptionPane.showMessageDialog(null, );
			// Executing Sql Query
			
			System.out.println("Added");
			frame.setLayout(null);
			frame.setSize(800,600);
			frame.setVisible(true);
			
			
					
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
	public static void main(String args[]){
		display_image("Marvel");
	}
	


}
