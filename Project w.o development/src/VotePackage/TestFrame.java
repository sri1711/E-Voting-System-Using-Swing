package VotePackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestFrame {
	
	public static void display_image(String Party_name){
		JFrame frame = new JFrame();
		Connection conn = null;
		try{
			
			//Url of DataBase
			String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/voter_registration.db";
			
			
			//Connecting Database 
			conn = DriverManager.getConnection(url);
			System.out.println("\n Connected");
			
			
			//Sql Query to execute
			String sqlquery = "SELECT * FROM VoterRegistration WHERE VoterId=?";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sqlquery);
			ps.setString(1,Party_name);
			rs = ps.executeQuery();
			try{
			
				BufferedImage image = null;
				
				while(rs.next()){
						InputStream input = new BufferedInputStream( rs.getBinaryStream("VoterPhoto"));
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
	private static int start_hr;
	private static int start_min;
	private static int start_sec;
	private static int end_hr;
	private static int end_min;
	private static int end_sec;
	
	public void time_Display(){
			Calendar cal = Calendar.getInstance();	      	      
			System.out.println(cal.getTime().toString());
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min  = cal.get(Calendar.MINUTE);
			int sec  = cal.get(Calendar.SECOND);
			System.out.println("Hour (24 hour format) : " + hour);
			System.out.println("Minute : " + min);
			System.out.println("Second : " + sec);
			
			FileInputStreamMethod();
			
			if(hour > start_hr && hour  < end_hr){
				System.out.println("vote");
			}
			else{
			}
			
			System.out.println("Millisecond : " + cal.get(Calendar.MILLISECOND));
	}
		
	public static void FileOutputStreamMethod(){
			try{
				FileOutputStream output = new FileOutputStream("Time.txt");
				String data = "06:00:00\n20:00:00";
				byte[] data_array = data.getBytes();
				output.write(data_array);
				output.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
	
	public static void FileInputStreamMethod(){
		try{
			FileInputStream input = new FileInputStream("time.txt");
			byte[] data_array = new byte[input.available()];
			input.read(data_array);
			//System.out.println(data_array.length);
			String str = new String(data_array);
			System.out.println(str);
			int index = str.indexOf("\n");
			System.out.println(index);
			start_hr = Integer.parseInt(str.substring(0, 2));
			start_min = Integer.parseInt(str.substring(3, 5));
			start_sec = Integer.parseInt(str.substring(6, index));
			end_hr = Integer.parseInt(str.substring(index+1, index+3));
			end_min = Integer.parseInt(str.substring(index+4, index+6));
			end_sec = Integer.parseInt(str.substring(index+7, str.length()));
			
			System.out.println(start_hr);
			System.out.println(start_min);
			System.out.println(start_sec);
			System.out.println(end_hr);
			System.out.println(end_min);
			System.out.println(end_sec);
			
			
//			String start = str.substring(0, index);
//			String end = str.substring(index,str.length());
//			System.out.println(start);
//			System.out.println(end);
			input.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
//	public static void main(String[] args) {
//		time_Display()
//	}
}
