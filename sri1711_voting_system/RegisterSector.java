package VotePackage;


import java.awt.Color;
//import edu.duke.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RegisterSector {
	
	public static void Candidate_database(String Candidate_name,String Party_name,String Party_logo,String Candidate_image,String Party_email){
		Connection conn = null;
		try{
			
			//Url of DataBase
			String url = "jdbc:sqlite:D:/Eclipse/workspace/Elite Voting System/CandidateDatabase.db";
			
			//Connecting Database 
			conn = DriverManager.getConnection(url);
			System.out.println("\n Connected");
			
			//Sql Query to execute
			String sqlquery = "INSERT INTO CandidateDatabase(CandidateName,PartyName,PartyLogo,CandidateImage,PartyEmail) VALUES(?,?,?,?,?)";
			
			
			PreparedStatement ps = conn.prepareStatement(sqlquery);
			ps.setString(1,Candidate_name);
			ps.setString(2,Party_name);
			ps.setString(3,Party_logo);
			ps.setString(4,Candidate_image);
			ps.setString(5,Party_email);
			
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
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	
	public static void Candidate_register_frame(){
		JFrame frame  =  new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/blue_pattern.png")));
		
		
		// Setting BackGroundColor of frame
		frame.getContentPane().setBackground(new Color(248,248,248));
		
		// To add Election Commission Logo
		String url = "D:/Eclipse/workspace/Elite Voting System/images/ElectionComm-top-image.jpeg";
		JLabel image = new JLabel(new ImageIcon(url));
		Dimension image_size = image.getPreferredSize();
		image.setBounds(200, 25, image_size.width, image_size.height);
		
		// To add Title of this Frame
		JLabel frame_title = new JLabel("Candidate Registration");
		Dimension frame_title_size = frame_title.getPreferredSize();
		frame_title.setFont(frame_title.getFont().deriveFont(26f));
		frame_title.setBounds(250,125, frame_title_size.width*26, frame_title_size.height+26);
		frame_title.setForeground(new Color(255, 215, 0));
		frame.add(frame_title);
		
		
        JButton upload = new JButton("upload Candidate photo");
        upload.setBounds(150, 420, 150, 30);
        frame.add(upload);
        upload.setBackground(new Color(76,81,137));
        upload.setForeground(new Color(255, 215, 0));
        
        // To create space to upload photo
        ImageIcon candidate_icon = new ImageIcon("D:/Eclipse/workspace/Elite Voting System/images/user-3.jpg");
		Image candidate = candidate_icon.getImage();
		Image resizedImage_candidate = candidate.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
        JLabel photo = new JLabel(new ImageIcon(resizedImage_candidate));
        photo.setBounds(150,220,150,200);
        frame.add(photo);
        
        // To create Labels for inputs in frame
        JLabel Party_name        = new JLabel("Party Name*     : ");
        JLabel Candidate_name    = new JLabel("Candidate Name* : ");
        JLabel Party_sym         = new JLabel("Party_Image*    : ");
        JLabel Party_Email       = new JLabel("Party Email Id* : ");
        
        JButton Party_image      = new JButton("Upload");
        Party_image.setBounds(480,320,100,25);
        Party_image.setBackground(new Color(76,81,137));
        Party_image.setForeground(new Color(255, 215, 0));
        


        // Setting coordinates,width and height of labels in frame
        Party_name.setBounds(320,230,300,25);
        Candidate_name.setBounds(320,260,300,25);
        Party_Email.setBounds(320, 290, 300,25);
        Party_sym.setBounds(320,320,300,25);
       
        

        // Setting font for labels
        Party_name.setFont(new Font("Serif",Font.PLAIN,20));
        Party_name.setForeground(new Color(255, 215, 0));
        Candidate_name.setFont(new Font("Serif",Font.PLAIN,20));
        Candidate_name.setForeground(new Color(255, 215, 0));
        Party_sym.setFont(new Font("Serif",Font.PLAIN,20));
        Party_sym.setForeground(new Color(255, 215, 0));
        Party_Email.setFont(new Font("Serif",Font.PLAIN,20));
        Party_Email.setForeground(new Color(255, 215, 0));
        
        // adding labels to frame
        frame.add(image);
        frame.add(Party_name);
        frame.add(Candidate_name);
        frame.add(Party_sym);
        frame.add(Party_image);
        frame.add(Party_Email);

        // Textfield creation
        JTextField Party_name_tf = new JTextField("");
        JTextField Candidate_name_tf = new JTextField("");
        JTextField Party_Email_tf = new JTextField("");

        // Adding Textfield to frame 
        frame.add(Party_name_tf);
        frame.add(Candidate_name_tf);
        frame.add(Party_Email_tf);

        // setting coordinates ,width and height of textfields in frame
        Party_name_tf.setBounds(480,230,150,25);
        Candidate_name_tf.setBounds(480,260,150,25);
        Party_Email_tf.setBounds(480,290,150,25);
        
        
        	
        
        
        Party_name_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Party_name_tf.setForeground(new Color(255, 215, 0));
        Party_name_tf.setBackground(new Color(76,81,137));
        Candidate_name_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Candidate_name_tf.setForeground(new Color(255, 215, 0));
        Candidate_name_tf.setBackground(new Color(76,81,137));
        Party_Email_tf.setFont(new Font("Serif",Font.PLAIN,16));
        Party_Email_tf.setForeground(new Color(255, 215, 0));
        Party_Email_tf.setBackground(new Color(76,81,137));
        
        ArrayList<JLabel> labels_photo = new ArrayList<JLabel>();
        ArrayList<JLabel> labels_party_image = new ArrayList<JLabel>();


        //JButton Event Listener
        upload.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		photo.setVisible(true);
        		upload.setText("upload candidate photo");
        		
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(frame);
                JLabel label = new JLabel();
                if(option == JFileChooser.APPROVE_OPTION){
                	try{
                		
                		File file = fileChooser.getSelectedFile();
                		BufferedImage bi = ImageIO.read(file);
                		ImageIcon background_icon = new ImageIcon(bi);
                		Image im = background_icon.getImage();
                		Image resizedImage = im.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
                		JLabel Cphoto = new JLabel(new ImageIcon(resizedImage));
                		upload.setText(file.getName());
                		photo.setVisible(false);
                		frame.add(Cphoto);
                		labels_photo.add(Cphoto);
                		Cphoto.setBounds(150, 220, 150, 200);
                		if(labels_photo.size() > 1){
                			JLabel Cphoto_temp = labels_photo.get(0);
                			frame.remove(Cphoto_temp);
                			labels_photo.remove(0);
                		}
                		
                		
                	}
                	catch(Exception el){
                		el.printStackTrace();
                	}
    	   		   
                  
                }else{
                   label.setText("Open command canceled");
                }   
        	}
        });
        
        Party_image.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		Party_image.setText("Upload");
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                int option = fileChooser.showOpenDialog(frame);
                JLabel label = new JLabel();
                if(option == JFileChooser.APPROVE_OPTION){
                	try{
                		File file = fileChooser.getSelectedFile();
                		BufferedImage bi = ImageIO.read(file);
                		ImageIcon background_icon = new ImageIcon(bi);
                		Image im = background_icon.getImage();
                		Image resizedImage = im.getScaledInstance(90, 100, java.awt.Image.SCALE_SMOOTH);
                		JLabel Party_photo = new JLabel(new ImageIcon(resizedImage));
                		Party_image.setText(file.getName());
                		frame.add(Party_photo);
                		labels_party_image.add(Party_photo);
                		Party_photo.setBounds(640, 300, 100, 100);
                		if(labels_party_image.size() > 1){
                			JLabel Party_photo_temp = labels_party_image.get(0);
                			frame.remove(Party_photo_temp);
                			labels_party_image.remove(0);
                		}
                		
                	}
                	catch(Exception el){
                		el.printStackTrace();
                	}
    	   		   
                  
                }else{
                   label.setText("Open command canceled");
                }   
        	}
        });
        
        JButton Submit_button = new JButton("Submit");
        frame.add(Submit_button);
        Submit_button.setBounds(400, 400 , 100, 35);
        Submit_button.setBackground(new Color(76,81,137));
        Submit_button.setForeground(new Color(255, 215, 0));
        //Submit_button.setBorder(new Border());
        
        Submit_button.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		System.out.println("Clicked Submit Button");
        		if(!(Candidate_name_tf.getText().equals("")) && !(Party_name_tf.getText().equals("")) && labels_photo.size()!= 0 && labels_party_image.size()!=0 && !(Party_Email_tf.getText().equals(""))){
        			if((Party_Email_tf.getText()).contains("@")){
        				Candidate_database(Candidate_name_tf.getText(),Party_name_tf.getText(),"sfaf","Srtrt",Party_Email_tf.getText());
        				Candidate_name_tf.setText("");
        				Party_name_tf.setText("");
        				Party_Email_tf.setText("");
        				photo.setVisible(true);
        				(labels_party_image.get(0)).setVisible(false);
        			}
        			else{
        				JOptionPane.showMessageDialog(null, "Check Your Email Id");
        			}
        		}
        		else{
        			JOptionPane.showMessageDialog(null, "All fields are Mandatory");
        		}
        		
        	}
        });
		
		frame.setLayout(null);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		Candidate_register_frame();
		
	}

}
