import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.email.durgesh.*;

import javax.swing.*;
public class LoginSector{
	JTextField Voter_id = new JTextField();
	final String s = Voter_id.getText();
	static String bg="C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\Background.png";
	static String eci = "C:\\Users\\Anil\\eclipse-workspace\\Voting system\\src\\VoteLogin.jpeg";
	public void create_framel1() {
		JFrame l1 = new JFrame();
		l1.setContentPane(new JLabel(new ImageIcon(bg)));
		JLabel lb1 = new JLabel("Voter ID : ");
		JLabel Title = new JLabel("Login Page");
		JButton OTP = new JButton("Send OTP");
		JLabel ECI = new JLabel(new ImageIcon(eci));
		l1.add(ECI);
		l1.add(lb1);
		l1.add(Title);
		l1.add(OTP);
		ECI.setBounds(100,0,600,80);
		Title.setBounds(350, 100, 200, 50);
		OTP.setBounds(400, 275, 150, 50);
		OTP.setBackground(new Color(76,81,137));
		OTP.setFont(OTP.getFont().deriveFont(18f));
		Title.setForeground(new Color(255, 215, 0));
		//OTP.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		OTP.setForeground(new Color(255, 215, 0));
		Title.setFont(Title.getFont().deriveFont(28f));
		lb1.setBounds(175, 220, 200,50);
		lb1.setFont(lb1.getFont().deriveFont(28f));
		lb1.setForeground(new Color(255, 215, 0));
		//JTextArea Voter_id = new JTextArea();
	    l1.add(Voter_id);
		Voter_id.setBounds(350, 230, 200, 30);
		l1.setLayout(null);
		l1.setSize(800, 600);
		l1.getContentPane().setBackground(new Color(255,255,255));
		l1.setVisible(true);
		
			OTP.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e1) {
					try {
						Connection conn = null;
						String url = "jdbc:sqlite:F:/Completed_Registration/voter_registration.db";
						ResultSet rs = null;
						conn = DriverManager.getConnection(url);
						String sqlquery = "SELECT VoterId,MailId FROM VoterRegistration WHERE VoterId = ?";
						PreparedStatement ps =conn.prepareStatement(sqlquery);
						String s = Voter_id.getText();
						ps.setString(1, s);						
						rs = ps.executeQuery();
						Random r1 = new Random();
						int otp = r1.nextInt(999999);
							while(rs.next()) {
							try {
								Email email = new Email("ECIjavaproject@gmail.com","java*demo");
								email.setSubject("Your OTP for Login..");
								email.setFrom("ECIjavaproject@gmail.com", "Election Commision Of India");
								email.addRecipient(rs.getString("MailId"));
								email.setContent("<h1> It is time to cheer and give a vote without any fear by keeping your mind clear!</h1>"
						
										+ "<h2>Your OTP is "+otp+"</h2>", "text/html");
								email.send();
								JOptionPane.showMessageDialog(null, "OTP Sent successfully");
								//System.out.println("Sent successfully");
								conn.close();
							}
							catch(Exception e) {
								//e.printStackTrace();
								System.out.println(e.getMessage());
							}
						}
							if(Voter_id.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Please enter valid data");
							else
								JOptionPane.showMessageDialog(null, "Your VoterID doesn't match with given data");
					}
				catch(SQLException e ) {
					} 
				}
			});
		} 
	
	public static void main(String[] args) {
		//MainPage ob = new MainPage();
		//ob.main(args);
		LoginSector ls = new LoginSector();
		ls.create_framel1();
		//create_framel2();
	}
	public static void create_framel2() {
		JFrame admin = new JFrame();
		JLabel ECI = new JLabel(new ImageIcon(eci));
		admin.setContentPane(new JLabel(new ImageIcon(bg)));
		JButton admin_b = new JButton("View Live Status");
		JLabel admin_p = new JLabel("Vote Results");
		admin.add(admin_b);
		admin.add(admin_p);
		admin.add(ECI);
		ECI.setBounds(100,0,600,80);
		admin_p.setBounds(300, 100, 200, 50);
		admin_p.setForeground(new Color(255, 215, 0));
		admin_p.setFont(admin_p.getFont().deriveFont(28f));
		admin_b.setBounds(300, 250, 200, 50);
		admin_b.setFont(admin_b.getFont().deriveFont(20f));
		admin_b.setBackground(new Color(76,81,137));
		admin_b.setForeground(new Color(255, 215, 0));
		admin.setLayout(null);
		admin.setSize(800, 600);
		//admin.getContentPane().setBackground(new Color(255,255,255));
		admin.setVisible(true);
		
	}
	/*public static void create_framel3() {
		JFrame l3 = new JFrame();
	}
	public static void create_framel4() {
		JFrame l4 = new JFrame();
		
	}*/
}
