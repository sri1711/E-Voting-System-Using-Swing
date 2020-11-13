package VotePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.email.durgesh.*;

public class Admin {
	
	private static int otp ;
	private static boolean LoginStatus = false; 
	public static void  admin_otp_frame(){
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		
		//Links for the images used
		String url = "D:/Eclipse/workspace/Elite Voting System/images/ElectionComm-top-image.jpeg";
		String login_url ="D:/Eclipse/workspace/Elite Voting System/images/admin-login-button-3.png";
		String back_url ="D:/Eclipse/workspace/Elite Voting System/images/back-image.jfif";		
		
		//Creating Image Icons
		ImageIcon login_icon = new ImageIcon(login_url);
		ImageIcon back_icon = new ImageIcon(back_url);
				
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
//				String otp_in = otp_input.getText();
//				System.out.println(otp_in);
//				System.out.println(otp);
				if(!(otp_input.getText().equals(""))){
					if(otp == Integer.parseInt(otp_input.getText())){
						frame.dispose();
						LoginStatus = true;
						admin_main_frame();
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
				admin_username_frame();
			}
		});
		
		frame.setLayout(null);
		frame.setSize(800,600);
		frame.setVisible(true); 
	}
	
	public static void  admin_username_frame(){
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		
		//Links for the images used
		String url = "D:/Eclipse/workspace/Elite Voting System/images/ElectionComm-top-image.jpeg";
		String login_url ="D:/Eclipse/workspace/Elite Voting System/images/admin-login-button-3.png";
		String back_url ="D:/Eclipse/workspace/Elite Voting System/images/back-image.jfif";
				
		
		//Creating Image Icons
		ImageIcon login_icon = new ImageIcon(login_url);
		ImageIcon back_icon = new ImageIcon(back_url);
				
		//Creating Labels,Button,TextField
		JLabel image = new JLabel(new ImageIcon(url));
		JLabel frame_title = new JLabel("Admin Portal Login");
		frame_title.setForeground(new Color(255, 215, 0));
		JLabel username = new JLabel("Enter UserName  :  ");
		username.setForeground(new Color(255, 215, 0));
		JTextField username_input = new JTextField();
		username_input.setForeground(new Color(255, 215, 0));
	    username_input.setBackground(new Color(76,81,137));
	    username_input.setMargin(new Insets(2,10,2,10));
		
		JButton otp_button = new JButton("Send OTP");
		otp_button.setForeground(new Color(255, 215, 0));
		otp_button.setBackground(new Color(76,81,137));
		
		JButton back_button = new JButton("Back");
		back_button.setForeground(new Color(255, 215, 0));
		back_button.setBackground(new Color(76,81,137));
		
		//Adding components in frame 
		frame.add(image);
		frame.add(frame_title);
		frame.add(username);
		frame.add(username_input);
		frame.add(otp_button);
		frame.add(back_button);
		
		
		//Dimensions of  labels,buttons
		Dimension image_size = image.getPreferredSize();
		Dimension frame_title_size = frame_title.getPreferredSize();
		Dimension otp_size = username.getPreferredSize();
		
		frame_title.setFont(frame_title.getFont().deriveFont(32f));
		username.setFont(username.getFont().deriveFont(22f));
		
		//Setting coordinates and width and height of labels,buttons
		image.setBounds(200, 50, image_size.width, image_size.height);
		frame_title.setBounds(230, 150, frame_title_size.width*32, frame_title_size.height+32);
		username.setBounds(225, 250, otp_size.width*22, otp_size.height+22);
		username_input.setBounds(425, 260, 120, 25);
		otp_button.setBounds(400, 325, 100, 50);
		back_button.setBounds(275, 325, 100, 50);
		
		otp_button.addActionListener(new ActionListener(){
			@SuppressWarnings("restriction")
			public void actionPerformed(ActionEvent e){
				Random rand = new Random();
				otp = rand.nextInt(999999);
				String username_tf = username_input.getText();
				int flag=0;
				System.out.println(username_tf);
				if(username_tf.equals("sri1711")){
					String mail_id = "sriviveknathsr@gmail.com";
					try {
						//String mail_id = "vijaymangalani4588@gmail.com";	
						Email email = new Email("ecijavaproject@gmail.com","java*demo");
						email.setFrom("vijay.warriar4588@gmail.com", "Election Commision of India");
						email.setSubject("One Time password(OTP) for Admin Login");
						email.setContent("<h3> The Nation feels gratified of your honourable work. Thanks for your indispensible role in upgrading this nation.</h3>"
								
										+ "<h4>Your OTP is</h4> <h2>"+otp+"</h2>", "text/html");
						email.addRecipient(mail_id);
						email.send();
						JOptionPane.showMessageDialog(frame, "OTP Sent to your registered Mail Id");
						flag = 1;
						
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(frame, "OTP Not Sent.Retry Again!!");
							System.out.println(e1.getMessage());
						}
				}
				else if(username_tf.equals("vijay07")){
					String mail_id = "vijay.warriar4588@gmail.com";
					try{
						Email email = new Email("ECIjavaproject@gmail.com","java*demo");
						email.setFrom("ECIjavaproject@gmail.com", "Election Commision of India");
						email.addRecipient(mail_id);
						email.setSubject("One Time password(OTP) for Admin Login");
						email.setContent("<h3> The Nation feels gratified of your honourable work. Thanks for your indispensible role in upgrading this nation.</h3>"		
										+ "<h4>Your OTP is</h4> <h2>"+otp+"</h2>", "text/html");
						email.send();
						JOptionPane.showMessageDialog(frame, "OTP Sent to your registered Mail Id");
						flag = 1;
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(frame, "OTP Not Sent.Retry Again!!");
						System.out.println(e1.getMessage());
					}
					
				}
				else if(username_tf.equals("surya02")){
					String mail_id = "suryaedu71@gmail.com";
					try{
						Email email = new Email("ECIjavaproject@gmail.com","java*demo");
						email.setFrom("ECIjavaproject@gmail.com", "Election Commision of India");
						email.addRecipient(mail_id);
						email.setSubject("One Time password(OTP) for Admin Login");
						email.setContent("<h3> The Nation feels gratified of your honourable work. Thanks for your indispensible role in upgrading this nation.</h3>"
						     			+ "<h4>Your OTP is</h4> <h2>"+otp+"</h2>", "text/html");
						email.send();
						JOptionPane.showMessageDialog(frame, "OTP Sent to your registered Mail Id");
						flag = 1;
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(frame, "OTP Not Sent.Retry Again!!");
						System.out.println(e1.getMessage());
					}
				}
				else if(username_tf.equals("")){
					JOptionPane.showMessageDialog(frame, "Enter a valid Input");
				}
				else{
					JOptionPane.showMessageDialog(frame, "No Such Admin Exist!! \n use proper username");
					username_input.setText("");
				}
				if(flag==1){
					frame.dispose();
					admin_otp_frame();
				}
			}
		});
		
		back_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				MainPage.main(null);
			}
		});
		
		frame.setLayout(null);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	
	public static void admin_main_frame(){
			JFrame frame  = new JFrame();
			frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
			JLabel logo = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
			Dimension image_size = logo.getPreferredSize();		
			frame.add(logo);
			frame.setVisible(true);
			logo.setBounds(270,50,image_size.width,image_size.height);
			frame.setLayout(null);
			frame.setSize(900,600);
			

			JLabel title = new JLabel("Admin Portal");
		
			title.setBounds(325,150,350,50);
			title.setForeground(new Color(255, 215, 0));
			title.setOpaque(false);
			title.setFont(new Font("Serif",Font.PLAIN,45));
			frame.add(title);
			
			JButton Request_button  = new JButton("Requests");
			Request_button.setBounds(250,300,180,80);
			Request_button.setFont(new Font("Serif", Font.PLAIN,25));
			Request_button.setBackground(new Color(76,81,137));
			Request_button.setForeground(new Color(255, 215, 0));
			frame.add(Request_button);

			JButton Livestatus_button  = new JButton("Live Status");
			Livestatus_button.setBounds(460,300,180,80);
			Livestatus_button.setFont(new Font("Serif", Font.PLAIN, 25));
			Livestatus_button.setBackground(new Color(76,81,137));
			Livestatus_button.setForeground(new Color(255, 215, 0));
			frame.add(Livestatus_button);
			
			
			JButton logout_button = new JButton(" Logout ");
			logout_button.setBounds(355,400,180,80);
			logout_button.setFont(new Font("Serif", Font.PLAIN, 25));
			logout_button.setBackground(new Color(76,81,137));
			logout_button.setForeground(new Color(255, 215, 0));
			frame.add(logout_button);
			if(LoginStatus){
				JOptionPane.showMessageDialog(frame, "Login Successfull...");
				LoginStatus = false;
			}
			
			
			
			Request_button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					frame.dispose();
					candidate_request_frame();
					//Candidate_register_frame();
				}
			});
			
			Livestatus_button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					frame.dispose();
					LiveStatus();
				}
			});
			
			
			logout_button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					frame.dispose();
					admin_username_frame();
				}
			});

		
	}
	
    public static void candidate_request_frame(){
        JFrame frame  = new JFrame();
        frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
        JLabel logo = new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/EC_India.jpeg"));
        Dimension image_size = logo.getPreferredSize();     
        frame.add(logo);
        frame.setVisible(true);
        logo.setBounds(270,50,image_size.width,image_size.height);
        frame.setLayout(null);
        frame.setSize(900,600);

        JLabel title = new JLabel("Approvals required");
        title.setBounds(290,150,350,50);
        title.setForeground(new Color(255, 215, 0));
        title.setOpaque(false);
        title.setFont(new Font("Serif",Font.PLAIN,45));
        frame.add(title);

        JLabel no_approvals_text = new JLabel("No pending Approvals");
        no_approvals_text.setBounds(330,280,350,50);
        no_approvals_text.setForeground(new Color(255, 215, 0));
        no_approvals_text.setVisible(false);
        no_approvals_text.setFont(new Font("Serif",Font.PLAIN,25));
        frame.add(no_approvals_text);
        
        JButton back_button = new JButton("Back");
        back_button.setBounds(20, 20, 100, 50);
		back_button.setForeground(new Color(255,215,0));
		back_button.setBackground(new Color(76,81,137));
		back_button.setFont(back_button.getFont().deriveFont(18f));
		frame.add(back_button);
		
		DB.request_backend(frame,no_approvals_text);
		
		back_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				admin_main_frame();
			}
		});
		
        
		
    }
	
	
	public static void LiveStatus() {
		String eci = "images/EC_India.jpeg";
		JFrame frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("images/blue_pattern.png")));
		JLabel ECI = new JLabel(new ImageIcon(eci));
		JLabel votes = new JLabel("Votes Obtained");
		JButton back_button = new JButton("Back");
		ImageIcon candidate_icon = new ImageIcon("images/user-3.jpg");
		Image candidate = candidate_icon.getImage();
		Image resizedImage_candidate = candidate.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
        JLabel photo = new JLabel(new ImageIcon(resizedImage_candidate));
        photo.setBounds(150,220,150,200);
		frame.add(votes);
		frame.add(back_button);
		frame.add(ECI);
		
		ECI.setBounds(200,10, 400, 80);
		
		votes.setBounds(300, 100, 250, 50);
		votes.setForeground(new Color(255, 215, 0));
		votes.setFont(votes.getFont().deriveFont(28f));
		
		back_button.setBounds(20, 20, 100, 50);
		back_button.setForeground(new Color(255,215,0));
		back_button.setBackground(new Color(76,81,137));
		back_button.setFont(back_button.getFont().deriveFont(18f));
		DB.LiveStatusDb(frame);
		String Party_name = DB.getVoteCountStatus(frame);
		frame.setLayout(null);
		frame.setSize(800, 600);
		frame.setVisible(true);
		if(Party_name.equals("")){
			
			JOptionPane.showMessageDialog(frame, "No Party is leading at the moment");
		}
		else{
			JOptionPane.showMessageDialog(frame,  Party_name + " party is leading ");
		}
		
		
		
		back_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				admin_main_frame();
			}
		});
		
			
	}
	
	
	
	public static void main(String[] args){
		admin_main_frame();
	}

}