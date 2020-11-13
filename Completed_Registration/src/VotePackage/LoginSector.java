package VotePackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.email.durgesh.Email;

public class LoginSector {
	private static String Voter_Id;
	private static int otp;
	public static void voter_confirmation_frame(String Voter_id){
		JFrame frame = new  JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		JLabel logo = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
		Dimension image_size = logo.getPreferredSize();
		logo.setBounds(270,50,image_size.width,image_size.height);
		frame.add(logo);
		DB.get_Voter_Image(frame,Voter_id);
		JButton Confirm_button = new JButton("Confirm");
		frame.add(Confirm_button);
		Confirm_button.setBounds(400, 400, 200, 75);
		Confirm_button.setForeground(new Color(255, 215, 0));
		Confirm_button.setBackground(new Color(76,81,137));
		Confirm_button.setFont(Confirm_button.getFont().deriveFont(18f));
		
		Confirm_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Castvote_frame();
			}
		});
		
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(900,600);
	}
	
	
	public static void voter_username_frame() {
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		JLabel lb1 = new JLabel("Voter ID : ");
		JLabel Title = new JLabel("Login Page");
		JButton OTP = new JButton("Send OTP");
		JLabel ECI = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
		frame.add(ECI);
		frame.add(lb1);
		frame.add(Title);
		frame.add(OTP);
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
		JTextField  Voter_id = new JTextField(); 
	    frame.add(Voter_id);
		Voter_id.setBounds(350, 230, 200, 30);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setVisible(true);
		
		OTP.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e1) {
					Voter_Id = Voter_id.getText();
					ResultSet rs = DB.getEmail(Voter_Id);
					int flag=0;
					Random r1 = new Random();
					otp = r1.nextInt(999999);
					String status = "";
					try {
						status = rs.getString("VoteStatus");
					} 
					catch (SQLException e2) {
						System.out.println(e2.getMessage());
					}
					if(rs != null && status.equals("Not Voted")){
						try {
							while(rs.next()) {
								try {
									Email email = new Email("ECIjavaproject@gmail.com","java*demo");
									email.setSubject("Your OTP for Login..");
									email.setFrom("ECIjavaproject@gmail.com", "Election Commision Of India");
									email.addRecipient(rs.getString("MailId"));
									email.setContent("<h3> It is time to cheer and give a vote without any fear by keeping your mind clear!</h3>"
						
											+ "<h4>Your OTP is</h4> <h2>"+otp+"</h2>", "text/html");
									email.send();
									JOptionPane.showMessageDialog(frame, "OTP Sent to your registered Mail Id");
									flag=1;
								}
								catch(Exception e) {
									JOptionPane.showMessageDialog(frame, "OTP not sent!!\nRetry Again");
									System.out.println(e.getMessage());
								}
							}
						}
						
						catch (SQLException e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
					else if(status.equals("Voted")){
						JOptionPane.showConfirmDialog(frame, "The vote to this voter id has been validated");
						frame.dispose();
						MainPage.main(null);
					}
					else if(Voter_id.equals(""))
						JOptionPane.showMessageDialog(null, "Please enter valid data");
					else
						JOptionPane.showMessageDialog(null, "Your VoterID doesn't match with given data");
					if(flag==1){
						frame.dispose();
						voter_otp_frame(Voter_Id);
					}
				}
				
				
			});
		} 
	
	public static void voter_otp_frame(String Voter_id) {
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		
		//Links for the images used
		String url = "D:/Eclipse/workspace/Elite Voting System/images/ElectionComm-top-image.jpeg";
				
		//Creating Labels,Button,TextField
		JLabel image = new JLabel(new ImageIcon(url));
		JLabel frame_title = new JLabel("OTP Portal");
		frame_title.setForeground(new Color(255, 215, 0));
		JLabel otp_label = new JLabel("Enter OTP :  ");
		otp_label.setForeground(new Color(255, 215, 0));
		JTextField otp_input = new JTextField();
		otp_input.setForeground(new Color(255, 215, 0));
	    otp_input.setBackground(new Color(76,81,137));
	    otp_input.setMargin(new Insets(2,10,2,10));

		
		JButton otp_button = new JButton("Login");
		otp_button.setForeground(new Color(255, 215, 0));
		otp_button.setBackground(new Color(76,81,137));
		
		JButton back_button = new JButton("Back");
		back_button.setForeground(new Color(255, 215, 0));
		back_button.setBackground(new Color(76,81,137));
		
		//Adding components in frame 
		frame.add(image);
		frame.add(frame_title);
		frame.add(otp_label);
		frame.add(otp_input);
		frame.add(otp_button);
		frame.add(back_button);
		//JOptionPane.showMessageDialog(frame, "OTP Sent to your registered Mail Id");
		
		//otp_frame.getContentPane().setBackground(new Color(248, 248, 250));
		
		//Dimensions of  labels,buttons
		Dimension image_size = image.getPreferredSize();
		Dimension frame_title_size = frame_title.getPreferredSize();
		Dimension otp_size = otp_label.getPreferredSize();
		
		frame_title.setFont(frame_title.getFont().deriveFont(32f));
		otp_label.setFont(otp_label.getFont().deriveFont(22f));
		
		//Setting coordinates and width and height of labels,buttons
		image.setBounds(200, 50, image_size.width, image_size.height);
		frame_title.setBounds(300, 150, frame_title_size.width*32, frame_title_size.height+32);
		otp_label.setBounds(200, 250, otp_size.width*22, otp_size.height+22);
		otp_input.setBounds(400, 260, 120, 25);
		otp_button.setBounds(525, 325, 80, 40);
		back_button.setBounds(425, 325, 80, 40);
		
		otp_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(otp_input.getText().equals(""))){
					if(otp == Integer.parseInt(otp_input.getText())){
						frame.dispose();
						voter_confirmation_frame(Voter_id);
					}
					else{
						JOptionPane.showMessageDialog(frame, "Otp Entered Wrong !!");
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "Enter a valid otp");
				}
			}
		});
		
		back_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				voter_username_frame();				
			}
		});
		
		
		frame.setLayout(null);
		frame.setSize(800,600);
		frame.setVisible(true); 

		
	}
	
    public static void Castvote_frame(){
        JFrame frame  = new JFrame();
        frame.setContentPane(new JLabel(new ImageIcon("images/blue_pattern.png")));
        JLabel logo = new JLabel(new ImageIcon("images/EC_India.jpeg"));
        Dimension image_size = logo.getPreferredSize();     
        frame.add(logo);
        frame.setVisible(true);
        logo.setBounds(270,50,image_size.width,image_size.height);
        frame.setLayout(null);
        frame.setSize(900,600);

        JLabel title = new JLabel("Cast your vote");
        title.setBounds(290,150,350,50);
        title.setForeground(new Color(255, 215, 0));
        title.setOpaque(false);
        title.setFont(new Font("Serif",Font.PLAIN,40));
        frame.add(title);


        DB.castVote(frame,Voter_Id);
    }
	
	public static void main(String args[]){
		//r_frame01();
		voter_username_frame();
	}
}
