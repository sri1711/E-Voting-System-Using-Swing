import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome!!");
		//r_frame01();
		r_frame02();
	}

	public static void r_frame01(){
		JFrame frame  = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("data/blue_pattern.png")));
		JLabel logo = new JLabel(new ImageIcon("data/EC_India.jpeg"));
		Dimension image_size = logo.getPreferredSize();		
		frame.add(logo);
		frame.setVisible(true);
		logo.setBounds(270,50,image_size.width,image_size.height);
		frame.setLayout(null);
		frame.setSize(900,600);
		//frame.getContentPane().setBackground(new Color(248,248,248));

		JLabel title = new JLabel("Choose your role");
		//Dimension title_size = title.getPreferredSize();
		title.setBounds(290,150,350,50);
		title.setForeground(new Color(255, 215, 0));
		title.setOpaque(false);
		title.setFont(new Font("Serif",Font.PLAIN,45));
		frame.add(title);
		
		JButton candidate_register_button  = new JButton("Candidate");
		candidate_register_button.setBounds(250,300,180,80);
		candidate_register_button.setFont(new Font("Serif", Font.PLAIN,25));
		candidate_register_button.setBackground(new Color(76,81,137));
		candidate_register_button.setForeground(new Color(255, 215, 0));
		frame.add(candidate_register_button);

		JButton voter_register_button  = new JButton("Voter");
		voter_register_button.setBounds(460,300,180,80);
		voter_register_button.setFont(new Font("Serif", Font.PLAIN, 25));
		voter_register_button.setBackground(new Color(76,81,137));
		voter_register_button.setForeground(new Color(255, 215, 0));
		//rgb(51, 102, 255)
		frame.add(voter_register_button);

	}

	public static void r_frame02(){
		JFrame frame  = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("data/blue_pattern.png")));
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(900,600);

		JLabel logo = new JLabel(new ImageIcon("data/EC_India.jpeg"));
		Dimension image_size = logo.getPreferredSize();		
		frame.add(logo);
		logo.setBounds(250,50,image_size.width,image_size.height);

		JLabel title = new JLabel("Provide your data");
		title.setBounds(330,130,250,50);
		title.setForeground(new Color(255, 215, 0));
		title.setOpaque(false);
		title.setFont(new Font("Serif",Font.PLAIN,32));
		frame.add(title);

		JButton photo = new JButton("Click to upload \nyour photo");
		photo.setBounds(200,220,150,200);
		frame.add(photo);
		photo.setForeground(new Color(255, 215, 0));
		photo.setBackground(new Color(76,81,137));

		

		JLabel name  = new JLabel("Name : ");
		JLabel dob  = new JLabel("DOB : ");
		JLabel mail  = new JLabel("Mail : ");
		JLabel phone  = new JLabel("Phone : ");
		JLabel aadhar = new JLabel("Aadhar no : ");
		JLabel voterid = new JLabel("Voter ID : ");

		frame.add(name);
		frame.add(dob);
		frame.add(mail);
		frame.add(phone);
		frame.add(aadhar);
		frame.add(voterid);

		name.setForeground(new Color(255, 215, 0));
		dob.setForeground(new Color(255, 215, 0));
		mail.setForeground(new Color(255, 215, 0));
		phone.setForeground(new Color(255, 215, 0));
		aadhar.setForeground(new Color(255, 215, 0));
		voterid.setForeground(new Color(255, 215, 0));


		name.setFont(new Font("Serif",Font.PLAIN,20));
		dob.setFont(new Font("Serif",Font.PLAIN,20));
		mail.setFont(new Font("Serif",Font.PLAIN,20));
		phone.setFont(new Font("Serif",Font.PLAIN,20));
		aadhar.setFont(new Font("Serif",Font.PLAIN,20));
		voterid.setFont(new Font("Serif",Font.PLAIN,20));

		name.setBounds(380,230,80,25);
		dob.setBounds(380,260,80,25);
		mail.setBounds(380,290,80,25);
		phone.setBounds(380,320,80,25);
		aadhar.setBounds(380,350,100,25);
		voterid.setBounds(380,380,100,25);

		//aadhar.setBackground(Color.red);
		//aadhar.setOpaque(true);

		JTextField name_tf = new JTextField("");
		JTextField dob_tf = new JTextField("");
		JTextField mail_tf = new JTextField("");
		JTextField phone_tf = new JTextField("");
		JTextField aadhar_tf = new JTextField("");
		JTextField voterid_tf = new JTextField("");

		frame.add(name_tf);
		frame.add(dob_tf);
		frame.add(mail_tf);
		frame.add(phone_tf);
		frame.add(aadhar_tf);
		frame.add(voterid_tf);

		name_tf.setBackground(new Color(76,81,137));
		dob_tf.setBackground(new Color(76,81,137));
		mail_tf.setBackground(new Color(76,81,137));
		phone_tf.setBackground(new Color(76,81,137));
		aadhar_tf.setBackground(new Color(76,81,137));
		voterid_tf.setBackground(new Color(76,81,137));

		name_tf.setForeground(new Color(255, 215, 0));
		dob_tf.setForeground(new Color(255, 215, 0));
		mail_tf.setForeground(new Color(255, 215, 0));
		phone_tf.setForeground(new Color(255, 215, 0));
		aadhar_tf.setForeground(new Color(255, 215, 0));
		voterid_tf.setForeground(new Color(255, 215, 0));
		

		name_tf.setMargin(new Insets(2,10,2,10));
		dob_tf.setMargin(new Insets(2,10,2,10));
		mail_tf.setMargin(new Insets(2,10,2,10));
		phone_tf.setMargin(new Insets(2,10,2,10));
		aadhar_tf.setMargin(new Insets(2,10,2,10));
		voterid_tf.setMargin(new Insets(2,10,2,10));

		name_tf.setBounds(490,230,120,25);
		dob_tf.setBounds(490,260,120,25);
		mail_tf.setBounds(490,290,120,25);
		phone_tf.setBounds(490,320,120,25);
		aadhar_tf.setBounds(490,350,120,25);
		voterid_tf.setBounds(490,380,120,25);
		

		JButton submit = new JButton("Submit");
		submit.setBounds(470,420,170,40);
		frame.add(submit);
		submit.setFont(new Font("Serif", Font.PLAIN, 25));
		submit.setForeground(new Color(255, 215, 0));
		submit.setBackground(new Color(76,81,137));
		submit.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent ae){
   				String test="";
   					String[] s = {name_tf.getText(),dob_tf.getText(),mail_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText()};
   					for(int i=0;i<6;++i){  						
  						System.out.println("Inside for loop : ");
   						System.out.print(i);
   						if(s[i].isEmpty()==true){
   							 JOptionPane.showMessageDialog(frame, "Please enter all the valid data");
   							 test = "flagged";
   							 break;
   						}
   					}
   					if(test!="flagged"){
   						System.out.println("Checking Existance!");
   						if(DB.checkExistance(aadhar_tf.getText())==false){
   							System.out.println("Inserting now");
							DB.insert(name_tf.getText(),dob_tf.getText(),mail_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText());
							System.out.println("Done!");
   						}
   					else{
   					 	JOptionPane.showMessageDialog(frame, "User name already exists!");
   						}
   					}
   			//DB.insert(name_tf.getText(),dob_tf.getText(),phone_tf.getText(),aadhar_tf.getText(),voterid_tf.getText(),name_tf.getText());
   			}
		});

	}

}

class DB{
	// static Connection conn =null;
	// static String url = "jdbc:sqlite:data/voter_registration.db";
	public static void insert(String Name,String Dob,String MailId,String PhoneNumber,String AadharNumber,String VoterId){
		Connection conn =null;
		try{
		//String url = "jdbc:sqlite:D:/Java/mini_project/data/voter_registration.db";
		String url = "jdbc:sqlite:data/voter_registration.db";
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
			String url = "jdbc:sqlite:data/voter_registration.db";
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
}

